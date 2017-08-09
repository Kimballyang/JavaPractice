package laiofferClass18;

public class LargestAndSmallest {
	public int[] largestAndSmallest(int[] array){
		//Assumptions; array is not null & array.length >=1.
		int n = array.length;
		//indices(x, n-1-x) will be paired up, the larger numbers of 
		//each pair will be put on the left side, so after the comparisons,
		//the left of the arrays are the larger values for each pairs,
		//the right half of the array are the smaller values for each pairs.
		for (int i= 0; i <n/2; i++){
			if (array[i] < array[n -1-i]){
				swap(array,i,n-1-i);
			}
		}
		// The largest value should be the largest of the left half
		//the smallest value should be the smallest of the right half
		return new int[] {largest(array, 0, (n-1)/2),smallest(array, n/2, n-1)};
	}
	
	private int largest(int[] array, int left, int right){
		int largest = array[left];
		for (int i = left +1; i <= right; i++){
			largest = Math.max(largest, array[i]);
		}
		return largest;
	}
	private int smallest(int[] array, int left, int right){
		int smallest = array[left];
		for (int i = left +1; i <= right; i++){
			smallest = Math.min(smallest, array[i]);
		}
		return smallest;
	}
	
	private void swap(int[] array, int i, int j){
		int tmp =array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
