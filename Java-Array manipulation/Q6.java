import java.util.Scanner;
public class Q6{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		double[] grades=new double[10];
		int i;
		for (i=0;i<10;i++) {
			System.out.println("Enter the grade for student n°"+(i+1)+": ");
			grades[i]=sc.nextDouble();
		}
		double average=calculateAverage(grades);
		double median=calculateMedian(grades);
		int numberFailed=calculateNumberFailed(grades);
		int numberPassed=calculateNumberPassed(grades);
		System.out.println("The average of the grades is: "+average);
		System.out.println("The median of the grades is: "+median);
		System.out.println("The number of students who failed is: "+numberFailed);
		System.out.println("The number of students who passed is: "+numberPassed);
			
		

	}

	public static double calculateAverage(double[] notes){
		double result=0;
		int i;
		for (i=0;i<notes.length;i++) {
			result= result + (notes[i]/notes.length);
		}
		return result;
		
	}

	public static double calculateMedian(double[] notes){
		int i, j, max;
		double tmp;

		for (i = 0; i < notes.length - 1; i++) {
			max = i;
			for (j = i + 1; j < notes.length; j++) {
				if (notes[j] > notes[max]) {
					max = j;
				}
			}

			tmp = notes[max];
			notes[max] = notes[i];
			notes[i] = tmp;
		}
		if (notes.length %2==0) {
			int medianIndex1= ((notes.length/2)-1);
			int medianIndex2= (notes.length/2);
			double median= ((notes[medianIndex1]+notes[medianIndex2])/2);
			return median;
		}
		else {
			int medianIndex= (notes.length/2);
			double median=notes[medianIndex];
			return median;
		}	
			
		
	}

	public static int calculateNumberFailed(double[] notes){
		int i;
		int result=0;
		for(i=0;i<notes.length;i++){
			if (notes[i]<50) {
				result++;
			}
		}
		return result;
				
	}

	public static int calculateNumberPassed(double[] notes){
		int i;
		int result=0;
		for(i=0;i<notes.length;i++){
			if (notes[i]>=50) {
				result++;
			}
		}
		return result;
				
	}
}
