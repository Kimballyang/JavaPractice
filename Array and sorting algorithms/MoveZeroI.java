package laiofferClass1;

import java.util.Arrays;

/**
 * Given an array of integers, move all the 0s to the right end of the array.

*The relative order of the elements in the original array does not need to be maintained.

*Assumptions:

*The given array is not null.
*Examples:

*{1} --> {1}
*{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}

 * @author Ziru
 *
 */
public class MoveZeroI {
	public int[] moveZero(int[] array){
		if (array == null|| array.length <= 1){
			return array;
		}
		
		int left = 0;
		int right = array.length -1;
		while (left< right){
			if(array[left] != 0){
				left++;
			} else if (array[right] == 0){
				right--;
				
			}else{
				swap(array, left++, right--);
				
			}
		
		}
		return array;
		
	}
	private void swap(int[] array, int a, int b){
		int tmp = array[a];
		array[a]= array[b];
		array[b]= tmp;
	}
	
	public static void main(String[] args){
		MoveZeroI solution= new MoveZeroI();
		int[] array =null;
		array = solution.moveZero(array);
		System.out.println(Arrays.toString(array));
		
		
		array = new int[] {1, 2, 3, 0, 3, 0, 4, 0};
		array = solution.moveZero(array);
		System.out.println(Arrays.toString(array));
		
	}

}
