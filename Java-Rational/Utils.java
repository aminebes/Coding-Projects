/**
 * Utils is a class containing various utility methods.
 * 
 * @author Mohamed Amine Bessrour
 */
public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in an array of Strings representing the input array.
     * @param what an array of words to be replaced.
     * @param with an array of replacement words.
     * @return a new array idententical to 'in' except that all the occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with',
     * or null if the pre-conditions of the methods are violated.
     *
     * The method returns null whenever one of the preconditions of the methods is violated:
     * In particular, the formal parameters cannot be null.
     * For all three arrays, none of the elements can be null.
     * The query and replacement arrays must be of the same length.
     */
    public static String[] findAndReplace( String[] in, String[] what, String[] with ) {

        String[] out = null; // The new array to be returned
	      boolean valid = true; // True if the pre-conditions are satistified

      	// Testing pre-conditions

      	if ( in == null || what == null || with == null ) {
      	    valid = false;
      	} else {
      	    for ( int i=0; i<in.length && valid; i++ ) {
				if ( in[i] == null ) {
					valid = false;
  		        }
			}
			for ( int i=0; i<what.length && valid; i++ ) {
  		        if ( what[i] == null ) {
  		            valid = false;
  		        }
			}
			for ( int i=0; i<with.length && valid; i++ ) {
  		        if ( with[i] == null ) {
  		            valid = false;
  		        }
  	        }
			if ( what.length != with.length ) {
  		        valid = false;
			}
      	}

      	if ( valid ) {
      	    out = new String[ in.length ];
      	    for ( int i=0; i<in.length; i++ ) {
      		    int j = 0;
  		        while ( j < what.length && ! in[i].equals(what[j]) ) {
					j++;
  		        }
  		        if ( j < what.length ) {
					out[i] = with[j];
  		        } else {
  		          out[i] = in[i];
  		        }
      	    }
      	}
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.

        return out;
    }
}