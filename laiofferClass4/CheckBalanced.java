package laiofferClass4;
import java.util.*;

import javax.swing.tree.*;

public class CheckBalanced {
	public boolean isBalanced(TreeNode root){
		if (root== null){
			return true;
		}
		// use -1 to denote the tree is not balanced
		// >= 0 value means the treee is balanced and it is the height of the tree
		return height(root)!=-1;
	}
	private int height(TreeNode root){
		if (root == null){
			return 0;
		}
		int leftHeight = height(root.left);
		// if left subtree is already not balanced, we do not nedd to continue
		// and we can return -1 directly
		if (leftHeight == -1){
			return -1;
		}
		int rightHeight = height(root.right);
		if (rightHeight == -1){
			return -1;
		}
		// if not balanced, return -1
		if (Math.abs(leftHeight - rightHeight)>1){
			return -1;
		}
		return Math.max(leftHeight, rightHeight)+1;
	}
}
