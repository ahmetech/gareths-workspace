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
	
	
	private static int[] sort(int[] array)
	{
		ArrayList<Integer> sorted=new ArrayList<Integer>();
		while(!(array.length==0)){
			int size=array.length;
			for (int i = 0; i < array.length; i++) {
				int parentPlace=i;
				int parent=array[i];
				
			}
		}
		
		return array;
	}
	
	public static boolean doesHaveKidsLeft(int[] array, int parentPlace, int size){
		if(((2*parentPlace)+1)>=size){
			return false;
		}else return true;
	}
	
	public static boolean doesHaveKidsRight(int[] array, int parentPlace, int size){
		if(((2*parentPlace)+2)>=size){
			return false;
		}else return true;
	}
	
	public static int findLeft(int[] array, int parentPlace){
		int left=array[((2*parentPlace)+1)];
		return left;
	}
	
	public static int findRight(int[] array, int parentPlace){
		int right=array[((2*parentPlace)+2)];
		return right;
	}
	
	public static boolean checkChild(int parent, int child){
		if(parent<child){
			return true;
		}else return false;
	}
	
	public static void shiftUp(int parentPlace, int childPlace, int[] array){
		int temp=array[childPlace];
		array[childPlace]=array[parentPlace];
		array[parentPlace]=temp;
	}
	
	public static void removeandadd(int[] array, ArrayList<Integer> sorted){
		int size=array.length;
		int[] temp=new int[size-1];
		for(int i=0; i<temp.length; i++){
			temp[i]=array[i];
		}
		sorted.add(array[size-1]);
		array=temp;
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
