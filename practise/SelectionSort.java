package practise;

import java.util.Arrays;

public class SelectionSort {
	 public int[] selectionSort(int[] array){
		 if (array == null || array.length <= 1){
			 return array;
		 }
		 
		 for (int i = 0; i< array.length - 1; i++){
			 int min = i;
			 for (int j = i + 1; j < array.length -1; j++){
				 if ( array[j] < array[min]){
					 min = j;
				 }
			 }
			 swap(array, i, min);
		 }
		 return array;
	 }
	 public void swap(int[] array, int left, int right){
		 int tmp= array[left];
		 array[left] = array[right];
		 array[right] = tmp;
	 }
	 
	 public static void main(String[] args){
		 
		 SelectionSort solution = new SelectionSort();
		
		 int[] array = new int[] {2, 5, 3, 1, 4};
		 array = solution.selectionSort(array);
		 System.out.println(Arrays.toString(array));
	 }
	
}
