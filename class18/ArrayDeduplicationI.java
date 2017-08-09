package laiofferClass18;

import java.util.Arrays;

public class ArrayDeduplicationI {
	public int[] dedup(int[] array){
		//Assumptions: array is not null
		if(array.length <= 1){
			return array;
		}
		//slow pointer starts from 0 and array[0] is always valid.
		//slow pointer is "included" in the valid partition.
		int end = 0;
		for(int i =1; i < array.length; i++){
			//for any duplicate elements, we just ignore.
			if(array[i] != array[end]){
				array[++end] =array[i];
			}
		}
		//Notice: usually you don't have to copy the subarray, instead,
		//you can just return the length of valid subarray after dedup
		//since the operation is done in place.
		//this is only useful for laicode to validate the result.
		return Arrays.copyOf(array,end+1);
	}

}
