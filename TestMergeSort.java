/**
 * Class TestMergeSort
 *
 * Take any unsorted string array and return the sorted array names
 * 
 * @author Ahmad Chaudhry
 * @version 2018.03.18
 */
public class TestMergeSort {

	/**
	 * Method to divide array of names into left and right hand sides
	 * 
	 * @param theArray
	 *            the string of names being sorted
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void mergeSort(T[] theArray) {
		// the length of the array is greater than 2 objects, if less than two no need
		// to sort
		if (theArray.length >= 2) {
			// left hand side has half of the array objects
			T[] left = (T[]) new Comparable[theArray.length / 2];
			// right hand side has the other half plus one if odd number of array objects
			T[] right = (T[]) new Comparable[theArray.length - theArray.length / 2];

			// place names in left hand array
			for (int i = 0; i < left.length; i++) {
				left[i] = theArray[i];
			}
			// place names in right hand array
			for (int i = 0; i < right.length; i++) {
				right[i] = theArray[i + theArray.length / 2];
			}
			// mergesort the left hand array
			mergeSort(left);
			// mergesort the right hand array
			mergeSort(right);
			// combine both sorted arrays into one
			merge(theArray, left, right);
		}
	}

	/**
	 * Method to organize names in alphabetical order
	 * 
	 * @param theArray
	 *            the array to be sorted
	 * @param left
	 *            the left hand side of the array
	 * @param right
	 *            the right hand side of the array
	 */
	public static <T extends Comparable<T>> void merge(T[] theArray, T[] left, T[] right) {
		// start both arrays at index 0
		int a = 0;
		int b = 0;
		// from the first object to the last in the array
		for (int i = 0; i < theArray.length; i++) {
			// compare index to right and left cases
			if (b >= right.length || (a < left.length && (left[a]).compareTo(right[b]) < 0)) {
				// next object is left hand array at its current index
				theArray[i] = left[a];
				// move to the next object in the array
				a++;
			} else {
				// next object is the right hand array at its current index
				theArray[i] = right[b];
				// move to the next object in the array
				b++;
			}
		}
	}

	/**
	 * Main method used to call other methods for testing
	 * 
	 * @param args
	 *            contains the command-line arguments passed to the Java program
	 *            upon invocation
	 */
	public static void main(String[] args) {
		// list of names and numbers unsorted
		String[] names = { "Lisa", "Adam", "John", "Vicky", "George", "Beth", "Kate", "Aaron", "Jinny" };
		Integer[] numbers = { 1, 5, 6, 2, 6, 4, 47, 3 };

		// prints out the unsorted arrays
		System.out.println("Unsorted Array lists: ");
		for (String first : names) {
			System.out.print(first + " ");
		}
		System.out.println("");
		for (Integer second : numbers) {
			System.out.print(second + " ");
		}

		System.out.println("\n");

		// mergesort the arrays
		mergeSort(names);
		mergeSort(numbers);

		// prints the sorted arrays
		System.out.println("\nSorted Array lists: ");
		for (String third : names) {
			System.out.print(third + " ");
		}
		System.out.println("");
		for (Integer fourth : numbers) {
			System.out.print(fourth + " ");
		}
	}
}
