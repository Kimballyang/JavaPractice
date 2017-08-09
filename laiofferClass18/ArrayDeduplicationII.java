package laiofferClass18;

import java.util.Arrays;

public class ArrayDeduplicationII {
	public int[] dedup(int[] array){
		//Assumptions: array is not null.
		if(array.length <= 2){
			return array;
		}
		int end = 1;
		for(int i =2; i <array.length; i++){
			//Notice: we can do this because it is a sorted array, and 
			//array[i] == array[end-1] implies that
			//array[end-1] === array[end] ==array[i]
			//if it is not a sorted array we need to find other way out.
			if(array[i] != array[end -1]){
				array[++end] = array[i];
			}
		}
		return Arrays.copyOf(array, end+1);
	}

}
