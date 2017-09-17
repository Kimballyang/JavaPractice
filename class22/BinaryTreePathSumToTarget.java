package laiofferClass22;

import java.util.HashSet;
import java.util.Set;

// binary tree path sum to target ( the two nodes can be the same node and they
//can only be the path from root to one of the leaf nodes)
public class BinaryTreePathSumToTarget {
	public boolean exist(TreeNode root, int sum){
		if (root == null){
			return false;
		}
		// pass down the prefix of the path.
		List<TreeNode> path = new ArrayList<TreeNode>();
		return helper(root,path,sum);
		
	}
	
	private boolean helper(TreeNode root, List<TreeNode> path, int sum){
		path.add(root);
		//check if can find a subpath ended at root node,
		// the sum of the subpath is target.
		int tmp = 0;
		for (int i = path.size() -1; i >= 0; i--){
			tmp += path.get(i).key;
			if (tmp == sum){
				return true;
			}
		}
		if (root.left != null && helper(root.left, path, sum)) {
			return true;
		}
		if (root.right != null && helper(root.right, path, sum)) {
			return true;
			
		}
		// don't forget for the cleanUp when return to the previous level.
		path.remove(path.size() -1);
		return false;
	}
	
	//Method 2: an O(n) solution
	// Think about the related problem, how do you find if there is 
	// a subarray sum to target value?
	// If there is an O(n) solution to the above problem, we can extend 
	//it to each of the root -> leaf paths of the binary tree.
	
	public boolean existII(TreeNode root, int sum){
		if (root == null){
			return false;
		}
		Set<Integer> prefixSums = new HashSet<>();
		prefixSum.add(0);
		return helperII(root, prefixSums, 0, sum);
	}
	
	private boolean helperII(TreeNode root, Set<Integer> prefixSums, int prevSum, int
			sum){
		preSum += root.key;
		if (prefixSums.contain(prevSum - sum)){
			return true;
		}
		boolean needRemove = prefixSums.add(prevSum);
		if (root.left != null && helperII(root.left, prefixSums, prevSum, sum)) {
			return true;
		}
		if (root.right != null && helperII(root.right, prefixSums, prevSum, sum)){
			return true;
		}
		if (needRemove){
			prefixSums.remove(prevSum);
		}
		return false;
	}
	

}
