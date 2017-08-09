package laiofferClass21;

import javax.swing.tree.TreeNode;

public class DeleteBST {
	public TreeNode delete(TreeNode root, int key){
		if (root == null){
			return null;
		}
		if (key == root.key){
			if (root.left == null){
				return root.right;
			} else if (root.right == null){
				return root.left;
			} else if (root.right.left == null){
				root.right.left = root.left;
				return root.right;
			}else{
				TreeNode newRoot = deleteSmallest(root.right);
				newRoot.left = root.left;
				newRoot.right = root.right;
				return newRoot;
			}
		}
		if (key < root.key){
			root.left = delete(root.left, key);
		}else{
			root.right = delete(root.right, key);
		}
		return root;
	}
	
	private TreeNode deleteSmallest(TreeNode root){
		while (root.left.left != null){
			root = root.left;
		}
		TreeNode smallest = root.left;
		root.left = root.left.right;
		return smallest;
	}
		

}
