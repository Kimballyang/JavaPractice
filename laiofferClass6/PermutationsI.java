package laiofferClass6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsI {
	// 1. DFS solution with swapping
	public List<String> permutations(String set){
		List<String> result = new ArrayList<String>();
		if (set == null){
			return result;
		}
		char[] array = set.toCharArray();
		helper(array,0,result);
		return result;
	}
	// choose the character to be at the position of "index"
	//all the already chosen positions are (0,index -1)
	// all the candidate characters can be at position " index"
	//are in the sub-array of (index, array.length -1)
	private void helper(char[] array, int index, List<String> result){
		// terminate condition
		// only when we have chosen the characters for all the position,
		// we can have a complete permutation
		if(index == array.length){
			result.add(new String(array));
			return;
		}
		// all the possible characters could be placed at index are the
		//characters in the sub-array (index,array.length -1);
		for (int i= index; i<array.length; i++){
			swap(array, index,i);
			helper(array, index+1,result);
			//remember to swap back when back track to previous level
			swap(array, index,i);
		}
	}
	
	private void swap(char[] array, int left, int right){
		char tmp = array[left];
		array[left]=array[right];
		array[right]=tmp;
	}
	
	// 2. solution to maintain the order of all the permutations.
	public List<String> permutationsWithOrder(String set){
		List<String> result = new ArrayList<String>();
		if (set == null){
			return null;
		}
		char[] arraySet = set.toCharArray();
		Arrays.sort(arraySet);
		// record which index has been used in the original arraySet
		boolean[] used = new boolean[arraySet.length];
		StringBuilder cur = new StringBuilder();
		helperWithOrder(arraySet,used,cur,result);
		return result;
	}
	
	private void helperWithOrder(char[] array, boolean[] used, StringBuilder cur, 
			List<String> result){
		// terminate condition
		// when the permutation contains all the characters in the original array
		if (cur.length() == array.length){
			result.add(cur.toString());
			return;
		}
		//when picking the next char,always according to the order
		for(int i=0; i<array.length; i++){
			//if a character is already been used, we can not pick it
			// for a second time
			if(!used[i]){
				used[i]=true;
				cur.append(array[i]);
				helperWithOrder(array,used, cur, result);
				used[i]=false;
				cur.deleteCharAt(cur.length() -1);
			}
		}
	}

}
