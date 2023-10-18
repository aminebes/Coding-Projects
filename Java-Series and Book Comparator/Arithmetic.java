public class Arithmetic extends AbstractSeries {

    // instance variables
	public int i;
    public double S;

    public double next() {
		i++;
        S += i;
        return S;
        
    }
}