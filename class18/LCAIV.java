package laiofferClass18;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class LCAIV {
	public TreeNode lowestCommonAncestor(TreeNode root,List<TreeNode> nodes){
		//Assumptions: the list of nodes is not null or not empty
		//all the nodes in the list are guaranteed to be in the tree
		Set<TreeNode> set = new HashSet<>(nodes);
		return helper(root,set);
	}
	
	private TreeNode helper(TreeNode root, Set<TreeNode> set){
		if(root == null){
			return null;
		}else if(set.contains(root)){
			return root;
		}
		TreeNode l = helper(root.left, set);
		TreeNode r = helper(root.right,set);
		if(l != null && r != null){
			return root;
		}
		return l != null ? l:r;
	}

}
