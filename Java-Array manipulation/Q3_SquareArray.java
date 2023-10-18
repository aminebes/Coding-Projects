public class Q3_SquareArray{
	public static int[] createArray(int size) {
		int i;
		int[] arrayDemo=new int[size];
		for (i=0;i<size;i++){
			arrayDemo[i] = i * i;
		}
		return arrayDemo;
	}
	public static void main(String[] args){
		int[] result=createArray(13);
		int j;
		for (j=0;j<result.length;j++){
			System.out.println("The square of "+j+" is : "+result[j]);
		}
	}
}