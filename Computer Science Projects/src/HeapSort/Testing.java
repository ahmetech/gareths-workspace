package HeapSort;

import java.util.ArrayList;

public class Testing {
	public static void main(String[] args){
		int[] array= new int[11];
		array[0]=5;
		array[1]=10;
		array[2]=20;
		array[3]=4;
		array[4]=6;
		array[5]=80;
		array[6]=90;
		array[7]=1;
		array[8]=3;
		array[9]=4;
		array[10]=8;
		int[] sorted=sort(array);
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}
	}

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
			shiftDown(array[0], array[size-1], array);
			removeandadd(array, sorted);
		}
		int[] sortedArray=new int[sorted.size()];
		for(int i=0; i<sorted.size(); i++){
			sortedArray[i]=sorted.remove(0);
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
			}if(!(parentPlace==0)){
				int superParentPlace=findSuperParentPlace(parentPlace, array);
				int superParentValue=findSuperParentValue(parentPlace, array);
				if(checkParent(parentPlace, superParentValue, array)){
					shiftUp(parentPlace, superParentPlace, array);
				}
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
			}if(!(parentPlace==0)){
				int superParentPlace=findSuperParentPlace(parentPlace, array);
				int superParentValue=findSuperParentValue(parentPlace, array);
				if(checkParent(parentPlace, superParentValue, array)){
					shiftUp(parentPlace, superParentPlace, array);
				}
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
		int superParentPlace=0;
		if(parentPlace%2==0){
			superParentPlace=(parentPlace-2)/2;
		} else superParentPlace=((parentPlace-1)/2);
		return superParentPlace;
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
		int superParentPlace=0;
		if(parentPlace%2==0){
			superParentPlace=(parentPlace-2)/2;
		} else superParentPlace=((parentPlace-1)/2);
		int superParentValue=array[superParentPlace];
		return superParentValue;
	}

	public static boolean checkChild(int parentValue, int childValue){
		if(parentValue<childValue){
			return true;
		}else return false;
	}
	public static boolean checkParent(int parentPlace, int superParentValue, int[] array){
		int parentValue=array[parentPlace];
		if(parentValue<superParentValue){
			return false;
		}else return true;

	}

	public static void shiftDown(int parentPlace, int childPlace, int[] array){
		int temp=array[childPlace];
		array[childPlace]=array[parentPlace];
		array[parentPlace]=temp;
	}

	public static void shiftUp(int parentPlace, int superParentPlace, int[] array){
		int temp=array[superParentPlace];
		array[superParentPlace]=array[parentPlace];
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
}
