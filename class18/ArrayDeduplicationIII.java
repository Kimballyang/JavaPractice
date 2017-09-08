package laiofferClass18;

import java.util.Arrays;

public class ArrayDeduplicationIII {
	public int[] dedup(int[] array){
		//Assumptions: array is not null
		if (array == null || array.length <=1){
			return array;
		}
		int end = 0;
		//use flag to see if there is any duplicates of array[end].
		boolean flag = false;
		for(int i = 1; i <array.length; i++){
			if(array[i] == array[end]){
				flag = true;
			} else if(flag == true){
				//if there is duplicate, and flag is set,
				//array[end] should not be included in the valid subarray,
				//and we can just replace it with array[i] since next
				//we are going to check if there is any duplicate of array[i].
				array[end] = array[i];
				//reset flag tp false since we are processing another element now.
				flag = false;
			}else{
				// it array[i] != array[end] and flag is not set,
				//it means there is no duplicate of array[end] and it should be
				//included in the valid subarray.
				array[++end] = array[i];
			}
		}
		//do not forget that we need to chefck if there is any duplicates for the 
		// last array[end].
		return Arrays.copyOf(array, flag ? end: end +1);
	}

}
