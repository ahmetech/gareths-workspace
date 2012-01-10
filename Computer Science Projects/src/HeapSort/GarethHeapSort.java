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
				size=array.length;
				int parentPlace=i;
				checkLeft(array, parentPlace, size);
				checkRight(array, parentPlace, size);
			}
			int first= array[0];
			int second=array[array.length-1];
			shiftDown(0, array.length-1, array);
			array=removeandadd(array, sorted);
		}
		int[] sortedArray=new int[sorted.size()];
		for(int i=0; i<sorted.size(); i++){
			int temp1=sorted.get(sorted.size()-1-i);
			sortedArray[i]=temp1;
		}
		return sortedArray;
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

	public static void checkRight(int[] array, int parentPlace, int size){
		if(doesHaveKidsRight(array, parentPlace, size)){
			int parentValue=array[parentPlace];
			int childPlace=findRightPlace(array, parentPlace);
			int childValue=findRightValue(array, parentPlace);
			if(checkChild(parentValue, childValue)){
				shiftDown(parentPlace, childPlace, array);
				shiftUp(parentPlace, array);
			}
		}
	}

	public static void checkLeft(int[] array, int parentPlace, int size){
		if(doesHaveKidsLeft(array, parentPlace, size)){
			int parentValue=array[parentPlace];
			int childPlace=findLeftPlace(array, parentPlace);
			int childValue=findLeftValue(array, parentPlace);
			if(checkChild(parentValue, childValue)){
				shiftDown(parentPlace, childPlace, array);
				shiftUp(parentPlace, array);
			}
		}
	}


	public static int findLeftPlace(int[] array, int parentPlace){
		int left=(2*parentPlace)+1;
		return left;
	}
	public static int findRightPlace(int[] array, int parentPlace){
		int right=(2*parentPlace)+2;
		return right;
	}
	public static int findSuperParentPlace(int parentPlace, int[] array){
		if(!(parentPlace==0)){
			int superParentPlace=0;
			if(parentPlace%2==0){
				superParentPlace=(parentPlace-2)/2;
			} else superParentPlace=((parentPlace-1)/2);
			return superParentPlace;
		}return 0;
	}

	public static int findLeftValue(int[] array, int parentPlace){
		int left=array[((2*parentPlace)+1)];
		return left;
	}

	public static int findRightValue(int[] array, int parentPlace){
		int right=array[((2*parentPlace)+2)];
		return right;
	}

	public static int findSuperParentValue(int parentPlace, int[] array){
		if(!(parentPlace==0)){
			int superParentPlace=0;
			if(parentPlace%2==0){
				superParentPlace=(parentPlace-2)/2;
			} else superParentPlace=((parentPlace-1)/2);
			int superParentValue=array[superParentPlace];
			return superParentValue;
		}return 0;
	}

	public static boolean checkChild(int parentValue, int childValue){
		if(parentValue<childValue){
			return true;
		}else return false;
	}
	public static boolean checkParent(int parentPlace, int superParentPlace, int[] array){
		int parentValue=array[parentPlace];
		int superParentValue=findSuperParentValue(parentPlace, array);
		if(parentValue<superParentValue){
			return false;
		}else return true;

	}

	public static void shiftDown(int parentPlace, int childPlace, int[] array){
		int temp=array[childPlace];
		array[childPlace]=array[parentPlace];
		array[parentPlace]=temp;
	}

	public static void shiftUp(int parentPlace, int[] array){
		int superParentPlace=findSuperParentPlace(parentPlace, array);
		if(checkParent(parentPlace, superParentPlace, array)&&!(parentPlace==0)){
			int temp=array[superParentPlace];
			array[superParentPlace]=array[parentPlace];
			array[parentPlace]=temp;
			parentPlace=superParentPlace;
			shiftUp(parentPlace, array);
		}
	}

	public static int[] removeandadd(int[] array, ArrayList<Integer> sorted){
		int size=array.length;
		if(!(size==1)){
			int[] temp=new int[size-1];
			for(int i=0; i<temp.length; i++){
				temp[i]=array[i];
			}
			sorted.add(array[size-1]);
			array=temp;
		}else{
			int[] blah=new int[0];
			sorted.add(array[0]);
			array=blah;
		}
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
