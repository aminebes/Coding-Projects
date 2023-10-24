import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueue1<E extends LabelledPoint> implements PriorityQueueIF<E> {
    // Private instance variables
    private E[] heap;        // Array to represent the priority queue
    private int capacity;    // Maximum capacity of the priority queue

    /**
     * Constructor to initialize a priority queue with a given capacity.
     *
     * @param capacity The maximum capacity of the priority queue.
     * @throws IllegalArgumentException if capacity is less than or equal to 0.
     */
    public PriorityQueue1(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        // Initialize the heap with an array of LabelledPoint objects
        this.heap = (E[]) new LabelledPoint[capacity];
    }

    /**
     * Constructor to initialize a priority queue with a given capacity and
     * populate it with elements from an ArrayList.
     *
     * @param capacity The maximum capacity of the priority queue.
     * @param arrayList An ArrayList of elements to populate the priority queue.
     * @throws IllegalArgumentException if capacity is less than or equal to 0.
     * @throws NullPointerException if arrayList is null.

     */
    public PriorityQueue1(int capacity, ArrayList<E> arrayList) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        if (arrayList == null) {
            throw new NullPointerException("arrayList can't be null");
        }
        this.capacity = capacity;
        // Initialize the heap with an array of LabelledPoint objects
        this.heap = (E[]) new LabelledPoint[capacity];
        for (int i = 0; i < capacity; i++) {
            heap[i] = arrayList.get(i);
        }
    }

    /**
     * Adds an element to the priority queue.
     *
     * @param element The element to be added.
     * @return true if the element was added successfully, false otherwise.
     */
    @Override
    public boolean offer(E element) {
        if (element == null) {
            return false;
        }
        if (size() < capacity) {
            heap[size()] = element;
            sortHeap(); // Sort the heap after adding an element
        } else {
            if (element.getKey() < heap[size() - 1].getKey()) {
                heap[size() - 1] = element;
                sortHeap(); // Sort the heap after replacing the maximum element
            }
        }
        return true;
    }

    /**
     * Removes and returns the highest priority element from the priority queue.
     *
     * @return The highest priority element, or null if the queue is empty.
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E root = heap[heap.length - 1]; // Get the last element
        heap = Arrays.copyOf(heap, heap.length - 1); // Create a new array with the last element removed
        return root;
    }

    /**
     * Returns the highest priority element without removing it from the queue.
     *
     * @return The highest priority element, or null if the queue is empty.
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return heap[(size() - 1)]; // Return the maximum element
    }

    /**
     * Returns the current size of the priority queue.
     *
     * @return The number of elements in the priority queue.
     */
    @Override
    public int size() {
        int count = 0;
        for (E element : heap) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if the priority queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Sorts the heap in ascending order based on the key of the elements.
     */
    private void sortHeap() {
        // Sort the heap in ascending order based on the key
        Arrays.sort(heap, 0, size(), Comparator.comparingDouble(LabelledPoint::getKey));
    }

}
