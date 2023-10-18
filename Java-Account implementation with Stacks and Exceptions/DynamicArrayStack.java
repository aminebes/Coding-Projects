import java.util.EmptyStackException;
public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings("unchecked")

    // Constructor
    public DynamicArrayStack(int capacity) {
        if (capacity < DEFAULT_INC) {
            capacity = DEFAULT_INC;
        }
        elems = (E[]) new Object[capacity];
        top = 0;
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return (top == 0);
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() throws EmptyStackException {
		if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elems[top - 1];
    }

    @SuppressWarnings("unchecked")

    // Removes and returns the top element of this stack
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E saved = elems[--top];
        elems[top] = null; // scrub the memory!
        if (getCapacity() - top >= DEFAULT_INC && getCapacity() > DEFAULT_INC) {
            int newCapacity = Math.max(getCapacity() - DEFAULT_INC, DEFAULT_INC);
            E[] newElems = (E[]) new Object[newCapacity];
            System.arraycopy(elems, 0, newElems, 0, top);
            elems = newElems;
        }
        return saved;
    }

    @SuppressWarnings("unchecked")

    // Puts the element onto the top of this stack.
    public void push(E element) {
        if (top == getCapacity()) {
            int newCapacity = getCapacity() + DEFAULT_INC;
            E[] newElems = (E[]) new Object[newCapacity];
            System.arraycopy(elems, 0, newElems, 0, top);
            elems = newElems;
        }
        elems[top++] = element;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        elems = (E[]) new Object[DEFAULT_INC];
        top = 0;
    }

}