package laiofferClass1;

import java.util.Arrays;

public class QuickSort {
	
	public int[] quickSort(int[] array){
		//check null first
		if (array==null){
			return array;
			
		}
		quickSort (array, 0 , array.length-1);
		return array;
		
	}
	
	public void quickSort(int[] array, int left, int right){
		if (left >=right){
			return;
		}
		// define a pivot and use the pivot to partition the array
		int pivotPos = partition(array,left,right);
		// pivot is already at its position, when we do the recursive call on the two partitions
		// pivot should not be included in any of them
		quickSort(array, left,pivotPos -1);
		quickSort(array, pivotPos +1, right);
		
	}
	
	private int partition(int[] array, int left, int right){ 
		int pivotIndex = pivotIndex(left, right);
		int pivot = array[pivotIndex];
		//swap the pivot element to the right most position first
		swap(array, pivotIndex,right);
		int leftBound =  left;
		int rightBound = right-1;
		while(leftBound <= rightBound){
			if (array[leftBound]<pivot){
				leftBound++;
				
			} else if(array[rightBound] >= pivot){
				rightBound--;
				
			} else{
				swap(array,leftBound++,rightBound--);
				
			}
		}
		//swap back the pivot element
		swap(array, leftBound++, right);
		return leftBound;
		
	}
	// this in one of the ways defining the pivot, 
	// pick random element in the range of [left,right].
	
	private int pivotIndex(int left, int right){
		return left+(int) (Math.random() *(right-left+1));	
	}
	
	private void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left]= array[right];
		array[right]= temp;
	}
	
	public static void main( String[] args){
		QuickSort solution = new QuickSort();
		
		int[] array = null;
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));
		
		array= new int[0];
		array = solution.quickSort(array);
		System.out.println(Arrays.toString(array));
		
		array=  new int[] {2, 8, 9, 5, 4, 3};
		array= solution.quickSort(array);
		System.out.println(Arrays.toString(array));
					
	}

}
