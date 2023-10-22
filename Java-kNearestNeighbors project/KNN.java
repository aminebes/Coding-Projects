import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 * This class implements the k-Nearest Neighbors (KNN) algorithm.
 */
public class KNN {

    private PointSet pointSet; // The set of points used for nearest neighbor search.
    private int k; // The number of nearest neighbors to find.

    /**
     * Constructs a KNN object with a specified PointSet.
     *
     * @param pointSet The set of points used for nearest neighbor search.
     */
    public KNN(PointSet pointSet) {
        this.pointSet = pointSet;
        this.k = 0; // Default value for k, can be changed using setK method.
    }

    /**
     * Sets the value of k.
     *
     * @param k The number of nearest neighbors to find.
     * @throws IllegalArgumentException if k is not a positive integer.
     */
    public void setK(int k) {
        if (k > 0) {
            this.k = k;
        } else {
            throw new IllegalArgumentException("k must be a positive integer");
        }
    }

    /**
     * Finds the k-nearest neighbors of a query point.
     *
     * @param queryPoint The point for which neighbors are to be found.
     * @param version    The version of the algorithm to use (1, 2, or 3).
     * @return A list of labeled points representing the k-nearest neighbors.
     */
    public List<LabelledPoint> findNN(LabelledPoint queryPoint, int version) {
        List<LabelledPoint> points = pointSet.getPointsList();

        // Return an empty list if there are no points or k is invalid.
        if (points.isEmpty() || k <= 0) {
            return new ArrayList<>();
        }

        // Calculate distances and set them as keys for the points.
        for (LabelledPoint p : points) {
            double distance = queryPoint.distanceTo(p);
            p.setKey(distance);
        }

        // Use PriorityQueue to find k-nearest neighbors.
        PriorityQueueIF<LabelledPoint> priorityQueue;

        if (version == 1) {
            priorityQueue = new PriorityQueue1<>(k);
        } else if (version == 2) {
            priorityQueue = new PriorityQueue2<>(k);
        } else if (version == 3) {
            priorityQueue = new PriorityQueue3<>(k);
        } else {
            throw new IllegalArgumentException("Invalid version number");
        }

        for (LabelledPoint p : points) {
            priorityQueue.offer(p); // insert p in the priorityQueue
            if (priorityQueue.size() > k) { // if priorityQueue is full
                priorityQueue.poll();
            }
        }

        // Transfer neighbors to a list in order.
        List<LabelledPoint> neighbors = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            neighbors.add(priorityQueue.poll());
        }
        return neighbors;
    }

    /**
     * The main method reads command line arguments and performs KNN search.
     *
     * @param args An array of four arguments: version, k, dataset filename, query point filename.
     * @throws IOException if there is an error reading the input files or writing the output file.
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            System.err.println("Usage: java KNN <version number> <k> <dataset filename> <query point filename>");
            System.exit(1);
        }

        int version = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        String datasetname = args[2];
        String queryname = args[3];

        // Create a PointSet from the dataset file.
        PointSet pointSet = new PointSet(PointSet.read_ANN_SIFT(datasetname));

        // Create a KNN instance using the PointSet.
        KNN knn = new KNN(pointSet);

        // Set the value of k.
        knn.setK(k);

        // Read the query points from the query file.
        PointSet querySet = new PointSet(PointSet.read_ANN_SIFT(queryname));

        long startTime = System.currentTimeMillis(); // start timer

        // Create a BufferedWriter to write the results to a file.
        BufferedWriter writer = new BufferedWriter(new FileWriter("knn_" + version + "_" + k + "_" + querySet.getPointsList().size() + "_" + pointSet.getPointsList().size() + ".txt"));
        
        for (LabelledPoint queryPoint : querySet.getPointsList()) {
            List<LabelledPoint> neighbors = knn.findNN(queryPoint, version);
            String result = Integer.toString(queryPoint.getLabel()) + " : ";

            for (LabelledPoint neighbor : neighbors) {
                result += Integer.toString(neighbor.getLabel()) + ", ";
            }

            result = result.substring(0, result.length() - 2);
            writer.write(result);
            writer.newLine();

            System.out.println(result);
        }

        long endTime = System.currentTimeMillis(); // end timer
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
        writer.write("Execution time: " + (endTime - startTime) + " milliseconds");
        writer.newLine();
        writer.close();
    }
}
