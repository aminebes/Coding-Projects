public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {
	
		int n=1;
		while (true) {
			System.out.println("==== Setting lot capacity to: "+n+" ====");
			int average=0;
			for (int i=1; i<=NUM_RUNS;i++) {
				ParkingLot lot = new ParkingLot(n);
				Simulator sim = new Simulator(lot, hourlyRate, 86400);
				long start, end;
				start = System.currentTimeMillis();
				sim.simulate();
				end = System.currentTimeMillis();
				int queueSize= sim.getIncomingQueueSize();
				System.out.println("Simulation run "+i+" ("+(end - start)+"ms); Queue length at the end of simulation run: "+queueSize);
				average+=(queueSize/NUM_RUNS);
			}
			System.out.println();
			if (average<= THRESHOLD) {
				break;
			} else {
				n++;
			}
				
		}
		return n;
	}

	public static void main(String args[]) {
	
		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}