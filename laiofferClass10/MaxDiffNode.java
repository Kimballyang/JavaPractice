package laiofferClass10;

import javax.swing.tree.TreeNode;

public class MaxDiffNode {
	public TreeNode maxDiffNode(TreeNode root){
		if(root == null){
			return null;
			
		}
		TreeNode[] node = new TreeNode[1];
		int[] diff = new int[1];
		diff[0]= -1;
		numNodes(root,node,diff);
		return node[0];
	}
	//return the # of nodes in the subtree.
	private int numNodes(TreeNode root, TreeNode[] node, int[] diff){
		if(root == null){
			return 0;
		}
		int leftNum = numNodes(root.left, node, diff);
		int rightNum = numNodes(root.right, node,diff);
		if(Math.abs(leftNum - rightNum)> diff[0]){
		node[0] = root;
		diff[0]= Math.abs(leftNum - rightNum);
	}
	return leftNum + rightNum +1;

	}
}
