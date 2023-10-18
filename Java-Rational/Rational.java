public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
		this.numerator=numerator;
        denominator=1;
    }

    public Rational(int numerator, int denominator) {
	     this.numerator=numerator;
		 this.denominator=denominator;
		 reduce();
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
	     int commonDenominator=this.denominator*other.denominator;
		 int resultNumerator=(this.numerator*other.denominator)+(other.numerator*this.denominator);
		 Rational result=new Rational(resultNumerator,commonDenominator);
		 result.reduce();
		 return result;
    }

    public static Rational plus(Rational a, Rational b) {
		Rational sum=a.plus(b);
		return sum;
    	
    }

    // Transforms this number into its reduced form

    private void reduce() {
      int gcd= gcd(numerator,denominator);
      numerator=numerator/gcd;
      denominator=denominator/gcd;
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
	    if (a<0){
            a=-a;
        }
        if (b<0){
            b=-b;
        }

    	while (a != b) {
    	    if (a > b) {
    		     a = a - b;
			}
    	    else {
    		     b = b - a;
			}
		}
    	return a;
    }

    public int compareTo(Rational other) {
        double x= Double.valueOf((double)numerator/denominator);
		double y= Double.valueOf((double)other.getNumerator()/other.getDenominator());
        if (x<y){
            return -1;
        }
        else if (x==y){
            return 0;
        }
        else{
            return 1;
        }
    }

    public boolean equals(Rational other) {
        reduce();
        if((this.numerator*other.denominator)==(other.numerator*this.denominator) ){
            return true;
        }
        else {
			return false;
		}
    }

    public String toString() {
    	String result="";
    	if (denominator == 1) {
    	    result=result+numerator;
    	} else {
    	    result=result+numerator+'/'+denominator;
    	}
    	return result;
    }

}