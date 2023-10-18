/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 *
 */
public class Simulator {

	/**
	 * Length of car plate numbers
	 */
	public static final int PLATE_NUM_LENGTH = 3;

	/**
	 * Number of seconds in one hour
	 */
	public static final int NUM_SECONDS_IN_1H = 3600;

	/**
	 * Maximum duration a car can be parked in the lot
	 */
	public static final int MAX_PARKING_DURATION = 8 * NUM_SECONDS_IN_1H;

	/**
	 * Total duration of the simulation in (simulated) seconds
	 */
	public static final int SIMULATION_DURATION = 24 * NUM_SECONDS_IN_1H;

	/**
	 * The probability distribution for a car leaving the lot based on the duration
	 * that the car has been parked in the lot
	 */
	public static final TriangularDistribution departurePDF = new TriangularDistribution(0, MAX_PARKING_DURATION / 2,
			MAX_PARKING_DURATION);

	/**
	 * The probability that a car would arrive at any given (simulated) second
	 */
	private Rational probabilityOfArrivalPerSec;

	/**
	 * The simulation clock. Initially the clock should be set to zero; the clock
	 * should then be incremented by one unit after each (simulated) second
	 */
	private int clock;

	/**
	 * Total number of steps (simulated seconds) that the simulation should run for.
	 * This value is fixed at the start of the simulation. The simulation loop
	 * should be executed for as long as clock < steps. When clock == steps, the
	 * simulation is finished.
	 */
	private int steps;

	/**
	 * Instance of the parking lot being simulated.
	 */
	private ParkingLot lot;

	/**
	 * Queue for the cars wanting to enter the parking lot
	 */
	private Queue<Spot> incomingQueue;

	/**
	 * Queue for the cars wanting to leave the parking lot
	 */
	private Queue<Spot> outgoingQueue;

	/**
	 * @param lot   is the parking lot to be simulated
	 * @param steps is the total number of steps for simulation
	 */
	public Simulator(ParkingLot lot, int perHourArrivalRate, int steps) {
		
		if (perHourArrivalRate <= 0 || steps < 0) {
            throw new IllegalArgumentException("The steps and perHourArrivalRate cannot be negative.");
        }
		if (lot == null) {
			throw new NullPointerException("lot cannot be null.");
		}
		
	
		this.lot = lot;

		this.probabilityOfArrivalPerSec = new Rational(perHourArrivalRate, 3600);

		this.steps = steps;

		this.clock = 0;

		incomingQueue = new LinkedQueue<Spot>();
		outgoingQueue = new LinkedQueue<Spot>();
	}


	/**
	 * Simulate the parking lot for the number of steps specified by the steps
	 * instance variable
	 * NOTE: Make sure your implementation of simulate() uses peek() from the Queue interface.
	 */
	public void simulate() {
	
		this.clock = 0;
		
		while (clock < steps) {
	
			boolean carArrival= RandomGenerator.eventOccurred(probabilityOfArrivalPerSec);
			if (carArrival) {
				String plateNum=RandomGenerator.generateRandomString(PLATE_NUM_LENGTH);
				Car c= new Car(plateNum);
				Spot s= new Spot(c,clock);
				incomingQueue.enqueue(s);
			}
			int i=0;
			int occ=lot.getOccupancy();
			while (i<occ) {
				Spot spot=lot.getSpotAt(i);
				int time=spot.getTimestamp();
				int duration= (clock - time);
				if (duration== MAX_PARKING_DURATION) {
					Spot leavingSpot = lot.remove(i);
					occ--;
					i--;
					outgoingQueue.enqueue(leavingSpot);
				} else {
					Rational probabilityOfDeparture=departurePDF.pdf(duration);
					boolean carDeparture= RandomGenerator.eventOccurred(probabilityOfDeparture);
					if (carDeparture) {
						Spot leavingSpot = lot.remove(i);
						occ--;
						i--;
						outgoingQueue.enqueue(leavingSpot);
					}
				}
				i++;
			}
				
			
			if (! incomingQueue.isEmpty()) {
				Spot peekSpot= incomingQueue.peek();
				Car peekCar = peekSpot.getCar();
				boolean canItPark=lot.attemptParking(peekCar,clock);
				if (canItPark) {
					Spot dequeuedSpot= incomingQueue.dequeue();
					Car dequeuedCar = dequeuedSpot.getCar();
				}
			}
			if (! outgoingQueue.isEmpty()) {
				Spot dequeued= outgoingQueue.dequeue();
			}		

			clock++;
		}
	}
	
	

	public int getIncomingQueueSize() {
	
		int size=incomingQueue.size();
		return size;
	
	}
}