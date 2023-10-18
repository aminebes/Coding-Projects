public class Geometric extends AbstractSeries {

    private int currentTerm = 1;
    public static final double commonRatio = 0.5;

    public double next() {
		double sum = 1*(Math.pow(commonRatio,currentTerm)-1)/(commonRatio-1);
        currentTerm++;
        return sum;
    }

}