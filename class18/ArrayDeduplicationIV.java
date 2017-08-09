package laiofferClass18;

import java.util.Arrays;

public class ArrayDeduplicationIV {
	public int[] dedup(int[] array){
		//Assumptions: array is not null
		int end = -1;
		for (int i =0; i < array.length; i++){
			//we are using the left part of the original array as a stack.
		    // and the top element's index  is end. if the stack is empty(end == -1)
			//we just push the element into the stack, or if the element is not
			//the same as the top element of the stack, we can push the element into
			//the stack as well.
			if(end == -1 ||  array[end] != array[i]){
				array[++end] = array[i];
			}else{
				//otherwise, we ignore all consecutive duplicates and 
				//remove the top element of the stack.
				while (i +1 < array.length && array[i+1] == array[end]){
					i++;
				}
				end --;
			}
		}
		return Arrays.copyOf(array, end +1);
	}

}
