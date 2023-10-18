public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		int[] afterArray=new int[beforeArray.length+1];
		int i;
		for (i=0;i<=beforeArray.length;i++){
			if (i<indexToInsert) {
				afterArray[i]=beforeArray[i];
			}
			else if (i==indexToInsert) {
				afterArray[i]=valueToInsert;
			}
			else {
				afterArray[i]=beforeArray[i-1];
			}
		}
		return afterArray;
				
				
	}

	public static void main(String[] args){
		int[] oldArray=new int[]{1,5,4,7,9,6};
		int[] newArray=insertIntoArray(oldArray,3,15);
		System.out.println("Array before insertion: ");
		int i;
		for (i=0;i<oldArray.length;i++) {
			System.out.println(oldArray[i]);
		}
		System.out.println("Array after insertion of 15 at position 3: ");
		int j;
		for (j=0;j<newArray.length;j++) {
			System.out.println(newArray[j]);
		}
			
	}
}