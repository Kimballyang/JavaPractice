package laiofferClass10;

public class NumNodesLeft {
	static class TreeNode{
		int key;
		TreeNode left;
		TreeNode right;
		// store the #  of nodes in left subtree.
		int numNodesLeft;
		public TreeNode(int key){
			this.key= key;
		}
	}
	public void numNodesLeft(TreeNode root){
		numNodes(root);
	}
	//return the # of node in the subtree
	private int numNodes(TreeNode root){
		if(root == null){
			return 0;
		}
		//leftNum is the # of nodes in subtree of root.left
		int leftNum = numNodes(root.left);
		//rightNum is the # of nodes in subtree of root.right
		int rightNum = numNodes(root.right);
		//return the total # of nodes in the subtree of root.
		return leftNum +rightNum +1;
	}

}
