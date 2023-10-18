public abstract class AbstractSeries implements Series {

    public double[] take(int k) {
        double[] partialSums = new double[k];
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum = next();
            partialSums[i] = sum;
        }

        return partialSums;
    }
}