package laiofferClass22;

public class MaxPathSumBinaryTreeIII {
	public int maxPathSum(TreeNode root){
		//Assumptions: root is not null.
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root,max);
		return max[0];
	}
	
	private int helper(TreeNode root, int[] max){
		if (root == null){
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		int sin = Math.max(Math.max(left,  right), 0) + root.key;
		max[0] = Math.max(max[0], sin);
		return sin;
	}

}
