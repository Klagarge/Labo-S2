package lab11_debugging;

import java.util.Random;

/**
 * Class to run the test
 * 
 * @author Pierre Roduit (pierre.roduit@hevs.ch)
 * @author Pierre-André Mudry (pandre.mudry@hevs.ch)
 * @version 1.2
 * 
 */
public class Launcher {
	static final boolean TEST_ACCESS = false;
	static final boolean TEST_INSERTION = true;
	
	public static void main(String[] args) {
		// Create a random array and create its perfect equivalent with a Vector or a list
		final int size = 500000;
		final int position = 0;
		final int nTimes = 1000;

		int[] randomArray = createRandomArray(size, 10);		
		DynamicStructuresComparison test = new DynamicStructuresComparison(randomArray);
		
		if(TEST_ACCESS)
			test.testAccess(nTimes, position);
		if(TEST_INSERTION)
			test.testInsertion(nTimes, position);
	}

	/**
	 * Creates a random array
	 * 
	 * @param size
	 * @param maxValue
	 * @return
	 */
	static int[] createRandomArray(int size, int maxValue) {
		int[] result = new int[size];
		Random randomizer = new Random();
		for (int i = 0; i < size; i++) {
			result[i] = randomizer.nextInt(maxValue);
		}
		return result;
	}
}
