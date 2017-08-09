package laiofferClass24;

import java.util.*;

public class TreeSum {
	public List<List<Integer>> allTriples(int[] array, int target) {
		//Assumptions: array is not null, array.length >= 3.
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			//Our goal is to find i < j < k, such that 
			//array[i] + array[j] + array[k] == target,
			//To make sure there is no duplicate tuple,
			//we ignore all the duplicate possible i.
			//e.g, if we have 2, 2, 2 only the first 2 will be selected as i.
			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = array.length - 1;
			while (left < right) {
				int tmp = array[left] + array[right];
				if (tmp + array[i] == target) {
					result.add(Arrays.asList(array[i], array[left], array[right]));
					left++;
					//ignore all possible duplicate j as well
					while (left < right && array[left] == array[left - 1]) {
						left++;
					} 
				}else if (tmp + array[i] < target) {
						left++;
						} else {
						right--;
					}
				}
			}
			return result;
		}
	}


