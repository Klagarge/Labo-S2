package lab11_debugging;

/**
 * Class to test efficiency of arrays
 * 
 * @author Pierre Roduit (pierre.roduit@hevs.ch)
 * @author Pierre-André Mudry
 * @version 1.2
 * 
 */
public class SampleArray {
	/**
	 * Stored values
	 */
	int[] data;

	/**
	 * Constructor
	 */
	SampleArray(int[] inputArray) {
		data = inputArray.clone();
	}

	/**
	 * Increment an element by one
	 */
	void increment(int position) {
		if(position < data.length)
			data[position]++;
	}

	/**
	 * Insert a zero at the specified position
	 * 
	 * @param position
	 * @return
	 */
	void insertZero(int position) {
		int[] tmpArray;
		tmpArray = new int[data.length + 1];

		// Copy the elements till position
		for (int i = 0; i < position; i++) {
			tmpArray[i] = data[i];
		}
		// Move all the other element one position on the right
		for (int i = position; i < data.length; i++) {
			tmpArray[i + 1] = data[i];
		}
		// Insert a zero at position
		tmpArray[position] = 0;
		data = tmpArray;
	}
}
