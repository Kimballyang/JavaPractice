package laiofferClass22;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

import javax.swing.tree.TreeNode;

public class ReconstructBTLevel {
	public TreeNode reconstruct(int[] level, int[] in) {
		//Assumptions: level, in are not null,
		//there is no duplicate in the binary tree.
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++){
			inMap.put(in[i], i);
		}
		List<Integer> lList = new ArrayList<Integer>();
		for (int num : level){
			lList.add(num);
		}
		return helper(lList, inMap);
	}
	
	private TreeNode helper(List<Integer> level, Map<Integer, Integer> inMap){
		if (level.isEmpty()){
			return null;
		}
		TreeNode root = new TreeNode(level.remove(0));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int num : level) {
			if (inMap.get(num) < inMap.get(root.key)){
				left.add(num);
			}else {
				right.add(num);
			}
		}
		root.left = helper(left, inMap);
		root.right = helper(right, inMap);
		return root;
	}

}
