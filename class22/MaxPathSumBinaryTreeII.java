package laiofferClass22;

public class MaxPathSumBinaryTreeII {
	public int maxPathSum(TreeNode root){
		//Assumptions: root is not null.
		//max stores the global maximum path sum and will be 
		//updated during the recursion
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, max);
		return max[0];
	}
	
	//return the maximum path sum of the "single" path
	private int helper(TreeNode root, int[] max){
		if (root == null){
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;
		max[0] = Math.max(root.key + left + right, max[0]);
		return root.key + Math.max(left,  right);
	}

}
