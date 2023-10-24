/* ---------------------------------------------------------------------------------
A vector of Floats with its associated int label
It includes also a key that can be used to order LabelledPoint instances

(c) Robert Laganiere, CSI2510 2023
------------------------------------------------------------------------------------*/

public class LabelledPoint implements Comparable<LabelledPoint> {
    private Float[] vector;
    private int label;
    private double key;

    public LabelledPoint(Float[] vector, int label) {
        this.vector = vector;
        this.label = label;
        this.key = 0.0;
    }

    public int getLabel() {
        return label;
    }

    public Float[] getVector() {
        return vector;
    }

    public double getKey() {
        return key;
    }

    public void setKey(double k) {
        key = k;
    }

    public int getLength() {
        return vector.length;
    }

    public double distanceTo(LabelledPoint other) {
        double sum = 0;
        for (int i = 0; i < vector.length; i++) {
            float diff = vector[i] - other.vector[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < 4; i++) {
            sb.append(vector[i]).append(", ");
        }
        sb.append("..., ");
        for (int i = vector.length - 2; i < vector.length; i++) {
            sb.append(vector[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(")");
        return sb.toString();
    }

    @Override
    public int compareTo(LabelledPoint other) {
        return Double.compare(other.key, this.key);
    }
}
