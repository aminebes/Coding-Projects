public class DoorLock {
	// Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;


    // Constructor.
    public DoorLock( Combination combination ) {
        this.combination = combination;
        open=false;
        activated=true;
        numberOfAttempts=0;

    }

    // Access methods.

    public boolean isOpen() {
        return open;
    }

    public boolean isActivated() {
        return activated;
    }


    // Notice that numberOfAttempts is compared to
    // MAX_NUMBER_OF_ATTEMPTS only when its value has been
    // incremented, Also, numberOfAttempts should be set to zero when
    // activated is false.  Problems related to the combined action of
    // these two variables have caused problems for some students.

    public boolean open( Combination combination ) {


            activate(combination);

        if (activated == true && open==false ) {
               if( (numberOfAttempts < MAX_NUMBER_OF_ATTEMPTS) && combination.equals(combination)) {
                open= true;
            numberOfAttempts=0;
            return true;


            }
        }

            numberOfAttempts++;
            activated=false;
            return false;

    }

    public void activate( Combination c ) {
        if(combination.equals(c)){
            activated= true;}
        else{
            activated= false;}
    }
    }

