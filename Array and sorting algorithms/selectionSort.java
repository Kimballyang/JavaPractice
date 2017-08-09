package laiofferClass1;

import java.util.Arrays;

public class selectionSort{
	public int [] SelectionSort(int[] array){
		if (array == null || array.length <=1){
			return array;	
		}
		for (int i = 0; i < array.length - 1; i++){
			int min =i;
			for (int j = i + 1; j < array.length; j++){
				if (array[j] < array[min]){
					min = j;
				}
			}
			swap(array, i, min);
		}
		return array;
	}
	
	public void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left]=array[right];
		array[right]=temp;
	}
	
	public static void main(String[] args){
		selectionSort solution = new selectionSort();
		
		int [] array = null;
		array = solution.SelectionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[0];
		array = solution.SelectionSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int [] { 1, 5, 3, 4,8};
		array = solution.SelectionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
