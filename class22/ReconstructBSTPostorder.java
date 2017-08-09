package laiofferClass22;

public class ReconstructBSTPostorder {
	public TreeNode reconstruct(int[] post){
		//Assumptions: post is not null;
	   // there is no duplicate in the binary search tree.
		// Traversing position of the post order,
		// we traverse and construct the binary search tree
		//from the postOrder right to left.
		int[] index = new int[] {post.length -1};
		return helper(post, index, Integer.MIN_VALUE);
	}
	
	private TreeNode helper(int[] postorder, int[] index, int min){
		// Since it is a binary search tree,
		// the "min" is actually the root,
		//and we are using the root value to detemine the boundary
		//of left/right subtree
		if (index[0] < 0 || postorder[index[0]] <= min) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[index[0]--]);
		root.right = helper(postorder, index, root.key);
		root.left = helper(postorder, index, min);
		return root;
	}

}
