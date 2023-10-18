public class Iterative {

    public static BitList complement( BitList in ) {

        BitList result;
        result = new BitList();

        Iterator i = in.iterator();
        Iterator j = result.iterator();

        if ( ! i.hasNext() ) {

            j.add( BitList.ONE );

        } else {

            while ( i.hasNext() ) {
                int bit = i.next();

                if ( bit == BitList.ONE ) {
                    j.add( BitList.ZERO );
                } else {
                    j.add( BitList.ONE );
                }
            }

        }

        return result;
    }

    public static BitList or( BitList a, BitList b ) {

        BitList result;
        result = new BitList();

        Iterator i = a.iterator();
        Iterator j = b.iterator();

        Iterator k = result.iterator();

        if ( ! i.hasNext() ) {
             throw new IllegalArgumentException( "a is empty" );
        }
        if ( ! j.hasNext() ) {
             throw new IllegalArgumentException( "b is empty" );
        }
        while ( i.hasNext() ) {

            if ( ! j.hasNext() ) {
                throw new IllegalArgumentException( "b is shorter than a" );
            }
            int iBit = i.next();
            int jBit = j.next();

            if ( iBit == BitList.ONE || jBit == BitList.ONE ) {
                k.add( BitList.ONE );
            } else {
                k.add( BitList.ZERO );
            }
        }

        if ( j.hasNext() ) {
            throw new IllegalArgumentException( "b is longer than a" );
        }
        return result;
    }

	public static BitList and( BitList a, BitList b ) {

        BitList result;
        result = new BitList();

        Iterator i = a.iterator();
        Iterator j = b.iterator();

        Iterator k = result.iterator();

        if ( ! i.hasNext() ) {
             throw new IllegalArgumentException( "a is empty" );
        }
        if ( ! j.hasNext() ) {
             throw new IllegalArgumentException( "b is empty" );
        }
        while ( i.hasNext() ) {

            if ( ! j.hasNext() ) {
                throw new IllegalArgumentException( "b is shorter than a" );
            }
            int iBit = i.next();
            int jBit = j.next();

            if ( iBit == BitList.ONE && jBit == BitList.ONE ) {
                k.add( BitList.ONE );
            } else {
                k.add( BitList.ZERO );
            }
        }

        if ( j.hasNext() ) {
            throw new IllegalArgumentException( "b is longer than a" );
        }
        return result;
    }

	public static BitList xor( BitList a, BitList b ) {

        BitList result;
        result = new BitList();

        Iterator i = a.iterator();
        Iterator j = b.iterator();

        Iterator k = result.iterator();

        if ( ! i.hasNext() ) {
             throw new IllegalArgumentException( "a is empty" );
        }
        if ( ! j.hasNext() ) {
             throw new IllegalArgumentException( "b is empty" );
        }
        while ( i.hasNext() ) {

            if ( ! j.hasNext() ) {
                throw new IllegalArgumentException( "b is shorter than a" );
            }
            int iBit = i.next();
            int jBit = j.next();

            if ( ( iBit == BitList.ONE || jBit == BitList.ONE ) && !( iBit == BitList.ONE && jBit == BitList.ONE ) ) {
                k.add( BitList.ONE );
            } else {
                k.add( BitList.ZERO );
            }
        }

        if ( j.hasNext() ) {
            throw new IllegalArgumentException( "b is longer than a" );
        }
        return result;
    }
}
