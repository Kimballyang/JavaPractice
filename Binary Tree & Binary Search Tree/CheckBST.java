package laiofferClass4;

public class CheckBST {
	public boolean isBST(TreeNode root){
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private boolean isBST(TreeNode root, int min, int max){
		if(root==null){
			return true;
		}
		if (root.key <min || root.key >max){
			return false;
		}
		return isBST(root.left,min,root.key-1)
				&& isBST(root.right,root.key+1,max);
	}
}
