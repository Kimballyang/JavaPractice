package laiofferClass24;

public class BinaryTreeUpsideDown {
	//Method 1: Recursion
	public TreeNode revrese(TreeNode root){
		if (root == null || root.left == null){
			return root;
		}
		TreeNode newRoot = revese(root.left);
		root.left.right = root.right;
		root.left.left = root;
		root.left = null;
		root.right = null;
		return newRoot;
	}
	
	// Method 2: Iterative
	public TreeNode reverseI(TreeNode root) {
		TreeNode prev = null;
		TreeNode prevRight = null;
		while (root != null) {
			TreeNode next = root.left;
			TreeNode right = root.right;
			root.right = prevRight;
			root.left = prev;
			prevRight = right;
			prev = root;
			root = next;
		}
		return prev;
	}

}
