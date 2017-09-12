package laiofferClass21;

import javax.swing.tree.TreeNode;

public class ClosestNumberBST {
	public int closest(TreeNode root, int target){
		//Assumption: the given binary search tree is not null
		int result = root.key;
		//the closest number has to be on the path of finding
		//the target value in the binary search tree.
		while (root != null){
			if (root.key = target){
				return root.key;
			}else{
				if (Math.abs(root.key - target) < Math.abs(result - target)){
					result = root.key;
				}else if (root.key < target){
					root = root.right;
					
				}else{
					root = root.left;
				}
			}
	
		}
		return result;
	}

}
