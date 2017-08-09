package laiofferClass22;

public class MaxPathSumLeafToRoot {
	// Method 1: Pass down the prefix sum.
	public int maxPathSum(TreeNode root){
		return maxPathSum(root, 0);
	}
	
	private int maxPathSum(TreeNode root, int sum){
		sum += root.key;
		if (root.left == null && root.right == null){
			return sum;
		} else if (root.left == null) {
			return maxPathSum(root.right, sum);
		} else if (root.right == null) {
			return maxPathSum(root.left, sum);
		}
		return Math.max(maxPathSum(root.left,sum), maxPathSum(root.right,sum));
	}
	
	// Method 2: Bottom Up return the max suffix sum.
	public int maxPathSumII(TreeNode root) {
		//Assumptions: root != null
		if (root.left == null && root.right == null){
			return root.key;
		}
		if (root.left == null){
			return maxPathSum(root.right) + root.key;
		}
		if (root.right == null){
			return maxPathSum(root.left) + root.key;
		}
		return root.key + Math.max(maxPathSum(root.left), maxPathSum(root.right));
	}

}
