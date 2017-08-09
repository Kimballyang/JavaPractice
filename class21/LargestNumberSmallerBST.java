package laiofferClass21;

public class LargestNumberSmallerBST {
	public int largestSmaller(TreeNode root, int target){
		//Assumptions: the binary search tree is not null.
		int result = Integer.MIN_VALUE;
		while (root != null){
			if (root.key >= target){
				root = root.left;
			}else{
				//the candidates are all the nodes on the path of 
				//searching for target, which is smaller than target.
				// and notice that, the later searched node has larger
				//value than the earlier searched one
				result = root.key;
				root = root.right;
			}
		}
		return result;
	}

}
