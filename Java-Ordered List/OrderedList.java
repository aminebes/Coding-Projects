// import java.util.NoSuchElementException

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	
		
		private Comparable value;
      	private Node previous;
      	private Node next;
		
      	
		private Node ( Comparable value, Node previous, Node next ) {

			this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
    	head=new Node(null,head,head);
    }

    // The size of the list

	public int size() {
      	int count=0;
      	Node p;
      	p=head.next;
      	if(p==null) {
      		return count;
      	}
      	while(p!=head) {
      		count++;
      		p=p.next;
      	}
      	return count;
    }


    public Object get( int pos ) {
       if (pos>size()||pos<0) {
    	   throw new IndexOutOfBoundsException();
       }
       int count=0;
       Node p;
       p=head.next;
       while(count!=pos) {
    	   count++;
    	   p=p.next;
       }
       return p.value;
    }

    // Adding an element 

    public boolean add( Comparable o ) {
    	 boolean result=false;
      if(o==null) {
    	  throw new NullPointerException();
      }
      Node p =head;
      if(p.next==null) {
    	  Node newnode =new Node(o,head,head);
    	  p.next=newnode;
    	  p.previous=newnode;
    	  return true;
      }
      p=p.next;
      while(p!=head) {
       if (p.value.compareTo(o)<0) {
    	  p=p.next;
      	}
       else if(p.value.compareTo(o)==0) {
    	   return false;
       }
       
       else {
    	  Node newnode =new Node(o,p.previous,p);
     	  p.previous.next=newnode;
     	  p.previous=newnode;
     	  p=p.next;
     	  result=true;
     	  return result;
       }
      }
      p=p.previous;
      Node newnode =new Node(o,p,p.next);
	  p.next.previous=newnode;
	  p.next=newnode;
	  result=true;
	  return result;
      
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
    if (pos>size()||pos<0) {
     	  throw new IndexOutOfBoundsException();
        }
    int count=0;
    Node p;
    p=head.next;
    while(count!=pos) {
 	   count++;
 	   p=p.next;
    }
    p.previous.next=p.next;
    p.next.previous=p.previous;
    }

    

    public void merge( OrderedList other ) {
    	int count=0;
     while(count!=other.size()) {
    	 this.add((Comparable)other.get(count++));
     }
    		 
    }   
}