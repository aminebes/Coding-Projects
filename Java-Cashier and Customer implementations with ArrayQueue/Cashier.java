/**
 * @author {Mohamed Amine Bessrour}
 *
 * 
 */
public class Cashier{

    private static final String lineSeperator = System.getProperty( "line.separator" );

    private Queue<Customer> queue;
    private Customer currentCustomer;

    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;
    
    private boolean serving = false;
	
	public Cashier() {
		queue = new ArrayQueue<Customer>();
		currentCustomer = null;
		customersServed = 0;
		totalItemsServed = 0;
		totalCustomerWaitTime = 0;
	}
	
	public void addCustomer(Customer c) {
		queue.enqueue(c);
	}
	
	public int getQueueSize() {
		return queue.size();
	}
	
	public void serveCustomers(int currentTime) {
		if (currentCustomer == null && !queue.isEmpty()) {
            currentCustomer = queue.dequeue();
            totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
        }

        if (currentCustomer != null) {
            currentCustomer.serve();
            if (currentCustomer.getNumberOfItems() == 0) {
                totalItemsServed += currentCustomer.getNumberOfServedItems();
                customersServed++;
                currentCustomer = null;
            }
        }
	}
	
	public int getTotalCustomerWaitTime() {
		return totalCustomerWaitTime;
	}
	
	public int getTotalCustomersServed() {
		return customersServed;
	}
	
	public int getTotalItemsServed() {
		return totalItemsServed;
	}
	
	
	public String toString() {
		StringBuffer stats = new StringBuffer();

		stats.append( "Average waiting time (seconds) : " );
        stats.append( totalCustomerWaitTime / customersServed );
        stats.append( lineSeperator );
		stats.append( "Total number of customers served : " );
        stats.append( customersServed );
        stats.append( lineSeperator );
        stats.append( "Average number of items per customer : " );
        stats.append( totalItemsServed / customersServed );
        stats.append( lineSeperator );

        return stats.toString();
	}
}