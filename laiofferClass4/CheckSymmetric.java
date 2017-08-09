package laiofferClass4;

import javax.swing.tree.TreeNode;

public class CheckSymmetric {
	public boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		return isSymmetric(root.left,root.right);
	}
	
	private boolean isSymmetric(TreeNode one, TreeNode two){
		if(one == null && two == null){
			return true;
		}else if (one == null || two == null){
			return false;
		}else if (one.key !=two.key){
			return false;
		}
		return isSymmetric(one.left,two.right)
				&& isSymmetric(one.right,two.left);
	}
	

}
