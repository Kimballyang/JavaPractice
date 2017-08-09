package laiofferClass24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {
	// Method 1: DFS I.
	public List<String> subSets(String set) {
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] arraySet = set.toCharArray();
		//Make sure the multi-set is sorted so that we can dedup
		Arrays.sort(arraySet);
		StringBuilder sb = new StringBuilder();
		helper(arraySet, sb, 0, result);
		return result;
	}
	//index: at current level, detemine if the element at " index" should be
	// included in the subset or not.
	private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
		if (index == set.length) {
			result.add(sb.toString());
			return;
		}
		helper(set, sb.append(set[index]), index + 1, result);
		sb.deleteCharAt(sb.length() - 1);
		//skip all the consecutive and duplicate elements.
		while (index < set.length - 1 && set[index] == set[index + 1]) {
			index ++;
		}
		helper(set, sb, index + 1, result);
	}
	
	//Method 2: DFS II
	public List<String> subSetII(String set) {
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] arraySet = set.toCharArray();
		//Make sure the multi -set is sorted so that we can dedup.
		Arrays.sort(arraySet);
		StringBuilder sb = new StringBuilder();
		helperII(arraySet, sb, 0, result);
		return result;
	}
	// index: we pick the element by ascending order, "index" is the smallest
	//index we can pick for the subset.
	private void helperII(char[] set, StringBuilder sb, int index, List<String> result) {
		result.add(sb.toString());
		//for the consecutive duplicate elements, we only pick the first one.
		for (int i = index; i < set.length; i++) {
			if (i == index || set[i] != set[i -1]) {
				sb.append(set[i]);
				helperII(set,sb, i + 1, result);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}
