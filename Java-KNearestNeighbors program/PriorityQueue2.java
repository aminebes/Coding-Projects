import java.util.ArrayList;

/**
 * PriorityQueue2 class that implements the PriorityQueueIF interface with a generic type E
 * that extends LabelledPoint.
 *
 * @param <E> The type of elements to be stored in the priority queue.
 */
public class PriorityQueue2<E extends LabelledPoint> implements PriorityQueueIF<E> {
    // Private instance variables
    private ArrayList<E> heap; // ArrayList to hold the elements
    private int capacity; // Capacity of the priority queue

    /**
     * Constructor that takes a capacity as a parameter.
     *
     * @param capacity The maximum number of elements the priority queue can hold.
     * @throws IllegalArgumentException if capacity is non-positive.
     */
    public PriorityQueue2(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity; // Set the capacity
        heap = new ArrayList<>(capacity); // Initialize the ArrayList with the given capacity
    }

    /**
     * Constructor that takes both a capacity and an ArrayList of type E as parameters.
     *
     * @param capacity The maximum number of elements the priority queue can hold.
     * @param arrayList The ArrayList containing elements to be added to the priority queue.
     * @throws IllegalArgumentException if capacity is non-positive.
     * @throws NullPointerException if arrayList is null.
     */
    public PriorityQueue2(int capacity, ArrayList<E> arrayList) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        if (arrayList == null) {
            throw new NullPointerException("arrayList can't be null");
        }
        this.capacity = capacity; // Set the capacity
        heap = new ArrayList<>(capacity); // Initialize the ArrayList with the given capacity

        // Copy heap from the provided ArrayList up to the specified capacity
        for (int i = 0; i < capacity; i++) {
            heap.add(arrayList.get(i));
        }
    }

    /**
     * Method to add an element to the priority queue.
     *
     * @param e The element to be added.
     * @return true (as specified by the Collection interface)
     */
    @Override
    public boolean offer(E e) {
        heap.add(e); // Add the element
        upHeap(); // Perform the up-heap operation
        return true; // Return true to indicate success
    }

    /**
     * Method to remove and return the highest priority element from the queue.
     *
     * @return The highest priority element, or null if the queue is empty.
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null; // Return null if the queue is empty
        }
        E max = heap.get(0); // Get the highest priority element
        E lastElement = heap.remove(heap.size() - 1); // Remove the last element

        if (!isEmpty()) {
            heap.set(0, lastElement); // Set the root element to the last element
            downHeap(0); // Perform the down-heap operation
        }
        return max; // Return the highest priority element
    }

    /**
     * Method to return the highest priority element without removing it.
     *
     * @return The highest priority element, or null if the queue is empty.
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null; // Return null if the queue is empty
        }
        return heap.get(0); // Return the highest priority element
    }

    /**
     * Method to return the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    @Override
    public int size() {
        return heap.size(); // Return the size of the ArrayList
    }

    /**
     * Method to check if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty(); // Check if the ArrayList is empty
    }

    // Helper method to perform the up-heap operation
    private void upHeap() {
        int index = heap.size() - 1; // Index of the newly added element
        while (index > 0) {
            int parentIndex = (index - 1) / 2; // Index of the parent element
            E current = heap.get(index); // Current element
            E parent = heap.get(parentIndex); // Parent element

            // Compare the keys and swap if necessary
            if (current.getKey() <= parent.getKey()) {
                break;
            }
            heap.set(index, parent);
            heap.set(parentIndex, current);
            index = parentIndex;
        }
    }

    // Helper method to perform the down-heap operation
    private void downHeap(int index) {
        int leftChild = 2 * index; // Index of the left child
        int rightChild = 2 * index + 1; // Index of the right child
        int biggest = index; // Index of the element with the largest key

        // Compare with left child
        if (leftChild < heap.size() && heap.get(leftChild).getKey() > heap.get(biggest).getKey()) {
            biggest = leftChild;
        }

        // Compare with right child
        if (rightChild < heap.size() && heap.get(rightChild).getKey() > heap.get(biggest).getKey()) {
            biggest = rightChild;
        }

        // Swap if necessary and recursively perform down-heap
        if (biggest != index) {
            E temp = heap.get(index);
            heap.set(index, heap.get(biggest));
            heap.set(biggest, temp);
            downHeap(biggest);
        }
    }
}
