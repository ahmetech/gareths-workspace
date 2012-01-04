package HeapSort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// Sorting Skeleton Code
/*
 *  ******* THE ONLY METHOD YOU NEED 
 *  ******* TO MODIFY IS THE "SORT()"
 *  ******* METHOD. You can add methods
 *  ******* if necessary. For some
 *  ******* sorting methods, it WILL be
 *  ******* necessary
 */

public class GarethHeapSort {
	
	/*
	 * ** YOU CAN MODIFY ANYTHING FROM HERE UNTIL "END"
	 * ** FEEL FREE TO ADD METHODS AS REQUIRED
	 */
	
	
	//Methods to implement: sift down, sift up, left child, right child.
	private static int[] sort(int[] array)
	{
		
		return array;
	}
	
	public static void main(String[] args) {
		// Create the random number generator
		Random numGenerator = new Random();

		// randomly get a number to be the size of the array
		int arraySize;
		do
		{
			arraySize = numGenerator.nextInt();
		} while ((arraySize < 10) || (arraySize >= 100000));
		// make sure the array size is at least 10 and less than 100,000
		
		// create the array
		int[] toBeSorted = new int[arraySize];
		
		// populate the array with random numbers
		for (int i = 0; i < toBeSorted.length; i++)
		{
			toBeSorted[i] = numGenerator.nextInt();
			// no restrictions on the numbers to be placed in the array
		}
		
		// Create the sorted array to compare against
		int[] sortedArray = Arrays.copyOf(toBeSorted, toBeSorted.length);
		Arrays.sort(sortedArray);
		
		// Call the "sort" method on the original array
		int[] presumablySortedArray = sort(toBeSorted);
		
		// See if the arrays are equal
		if (Arrays.equals(sortedArray, presumablySortedArray))
		{
			System.out.print("Sorting worked. Not a guarantee of using the correct sorting algorithm though");
		}
		else
		{
			System.out.print("Sorting did not work");
		}
	}

}
