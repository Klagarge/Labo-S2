package lab11_debugging;

/**
 * Class used to compare resources consumption between different data structures
 * 
 * @author Pierre Roduit (pierre.roduit@hevs.ch)
 * @author Pierre-André Mudry (pandre.mudry@hevs.ch)
 * @version 1.2
 * 
 */
public class DynamicStructuresComparison {

	private SampleArray tstArray;
	private SampleVector tstVector;
	private SampleLinkedList tstList;	
	private int size;

	/**
	 * Constructor. Produce the three data structures
	 * 
	 * @param inputArray
	 */
	public DynamicStructuresComparison(int[] inputArray) {
		tstArray = new SampleArray(inputArray);
		tstVector = new SampleVector(inputArray);
		tstList = new SampleLinkedList(inputArray);

		// Define the position of insertion for the tests
		size = inputArray.length;		
	}

	/**
	 * Compare the difference between the data structures for the insertions
	 * 
	 * @param nTimes
	 *            Number of times the test is repeated
	 */
	public void testInsertion(int nTimes, int position) {
		long start, end;
		System.out.println("Insertion test with " + nTimes
				+ " insertions and an array size of " + size + " elements.");
		
		// Measure insertion with array
		start = System.nanoTime();
			this.repeatInsertArray(nTimes, position);
		end = System.nanoTime();					
		System.out.println("Array insertion took : \t" + ((end- start)/1000.0) + " uS");

		// Measure insertion with vector
		start = System.nanoTime();
			this.repeatInsertVector(nTimes, position);
		end = System.nanoTime();				
		System.out.println("Vector insertion took: \t" + ((end - start)/1000.0) + " uS");
		
		// Measure insertion with list
		start = System.nanoTime();
			this.repeatInsertList(nTimes, position);
		end = System.nanoTime();		
		System.out.println("List insertion took : \t" + ((end - start)/1000.0) + " uS");
	}

	/**
	 * Compare the difference between the data structures for access
	 * 
	 * @param nTimes
	 *            Number of times the test is repeated
	 */
	public void testAccess(int nTimes, int position) {
		long start, end;
		System.out.println("Access test of the whole data with " + nTimes
				+ " repetitions and an array size of " + size + " elements.");
		
		// Measure insertion with array
		start = System.nanoTime();		
			this.repeatAccessArray(nTimes, position);
		end = System.nanoTime();		
		System.out.println("Array access took : \t\t" + ((end- start)/1000) + " uS");
		
		// Measure insertion with list
		start = System.nanoTime();		
			this.repeatAccessVector(nTimes, position);
		end = System.nanoTime();		
		System.out.println("Vector access took : \t\t" + ((end- start)/1000) + " uS");
		
		
		// Measure insertion with list		
		start = System.nanoTime();
			this.repeatAccessList(nTimes, position);
		end = System.nanoTime();		
		System.out.println("List access took : \t\t" + ((end- start)/1000) + " uS");
	}

	/**
	 * Make a specific number of insertions
	 * 
	 * @param number
	 */
	private void repeatInsertArray(int repetitions, int position) {
		for (int i = 0; i < repetitions; i++) {
			tstArray.insertZero(position);
		}
	}

	/**
	 * Make a specific number of insertions
	 * 
	 * @param number
	 */
	private void repeatInsertVector(int repetitions, int position) {
		for (int i = 0; i < repetitions; i++) {
			tstVector.insertZero(position);
		}
	}

	/**
	 * Make a specific number of insertions
	 * 
	 * @param number
	 */
	private void repeatInsertList(int repetitions, int position) {
		for (int i = 0; i < repetitions; i++) {
			tstList.insertZero(position);
		}
	}

	/**
	 * Make a specific number of access to the whole data
	 * 
	 * @param number
	 */
	private void repeatAccessArray(int repetitions, int position){
		for (int i = 0; i < repetitions; i++) {
			tstArray.increment(position);
		}
	}

	/**
	 * Make a specific number of access to the whole data
	 * 
	 * @param number
	 */
	private void repeatAccessVector(int repetitions, int position){
		for (int i = 0; i < repetitions; i++) {
			tstVector.increment(position);
		}
	}

	/**
	 * Make a specific number of access to the whole data
	 * 
	 * @param number
	 */
	private void repeatAccessList(int repetitions, int position){
		for (int i = 0; i < repetitions; i++) {
			tstList.increment(position);
		}
	}
}
