import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Define a generic class PriorityQueue3 that implements the PriorityQueueIF interface for a specified type E.
 *
 * @param <E> The type of elements stored in the priority queue.
 */
public class PriorityQueue3<E extends LabelledPoint> implements PriorityQueueIF<E> {
    // Private instance variables
    private PriorityQueue<E> heap; // Priority queue to store elements
    private int capacity; // Maximum capacity of the queue

    /**
     * Constructor that initializes the priority queue with a specified capacity.
     *
     * @param capacity The maximum capacity of the priority queue.
     * @throws IllegalArgumentException if capacity is non-positive.
     */
    public PriorityQueue3(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.heap = new PriorityQueue<E>(); // Initialize the priority queue with the default comparator
        this.capacity = capacity;
    }

    /**
     * Constructor that initializes the priority queue with a specified capacity and elements from an ArrayList.
     *
     * @param capacity The maximum capacity of the priority queue.
     * @param arrayList The ArrayList containing elements to be added to the priority queue.
     * @throws IllegalArgumentException if capacity is non-positive.
     * @throws NullPointerException if arrayList is null.
     */
    public PriorityQueue3(int capacity, ArrayList<E> arrayList) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        if (arrayList == null) {
            throw new NullPointerException("arrayList can't be null");
        }

        this.heap = new PriorityQueue<E>(capacity); // Initialize the priority queue with the specified capacity
        this.capacity = capacity;

        // Add elements from the ArrayList to the priority queue
        for (int i = 0; i < capacity; i++) {
            heap.add(arrayList.get(i));
        }
    }

    /**
     * Override the isEmpty method from the interface.
     *
     * @return true if the priority queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Override the offer method from the interface.
     *
     * @param item The item to be added to the priority queue.
     * @return true if the item is added successfully, false otherwise.
     */
    @Override
    public boolean offer(E item) {
        return heap.offer(item);
    }

    /**
     * Override the poll method from the interface.
     *
     * @return The item with the highest priority, or null if the priority queue is empty.
     */
    @Override
    public E poll() {
        return heap.poll();
    }

    /**
     * Override the peek method from the interface.
     *
     * @return The item with the highest priority, or null if the priority queue is empty.
     */
    @Override
    public E peek() {
        return heap.peek();
    }

    /**
     * Override the size method from the interface.
     *
     * @return The number of elements in the priority queue.
     */
    @Override
    public int size() {
        return heap.size();
    }
}
