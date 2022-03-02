package lab11_debugging;

import java.util.Random;

/**
 * Class to try the debugger
 * 
 * @author Pierre Roduit (pierre.roduit@hevs.ch)
 * @author PA Mudry (pierre-andre.mudry@hevs.ch)
 * @version 1.1
 * 
 */
public class NumberAnalyzer {
	public static void main(String[] args) {
		int[] array = createRandomArray(100, 100);
		displayArray(array);
		int position = firstRepeatedNumber(array);
		System.out.println("The first repeated element is at location " + position);
	}

	/**
	 * Function search for the first element repeated in the vector. It returns
	 * the position of this duplicated element.
	 * 
	 * @param inputArray The input array
	 * @return The position of the first repeated element
	 */
	public static int firstRepeatedNumber(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == inputArray[i + 1])
				return i;
		}
		return -1;
	}

	/**
	 * Create a random array
	 * 
	 * @param size
	 *            Number of element of the array produced
	 * @param maxValue
	 *            Maximal value of the generated elements
	 * @return The generated array
	 */
	static int[] createRandomArray(int size, int maxValue) {
		int[] result = new int[size];
		Random randomizer = new Random();
		for (int i = 0; i < size; i++) {
			result[i] = randomizer.nextInt(maxValue);
		}
		return result;
	}

	/**
	 * Display the array
	 * 
	 * @param array
	 *            The array to display
	 */
	static void displayArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
	}
}
