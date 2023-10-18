public class ITIStringBuffer {

    private SinglyLinkedList<char[]> buffer;
    private int length;
    
    public ITIStringBuffer() {
        buffer = new SinglyLinkedList<>();
        length = 0;
    }
    
    public ITIStringBuffer(String firstString){
		this();
		if (firstString==null) {
			throw new NullPointerException("String cannot be null.");
		}
        append(firstString);
    }
    
    public void append(String nextString){
		
        if (nextString==null) {
			throw new NullPointerException("String cannot be null.");
		}
        buffer.add(nextString.toCharArray());
        length += nextString.length();
    }
    
    public String toString(){
        char[] result = new char[length];
        int offset = 0;
        for (char[] arr : buffer) {
            System.arraycopy(arr, 0, result, offset, arr.length);
            offset += arr.length;
        }
        return new String(result);
    }

}
