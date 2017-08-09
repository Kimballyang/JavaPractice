package laiofferClass5;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class CheckCompleted {
	public boolean isCompleted(TreeNode root){
		if (root == null){
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// if the flage is set true, there should not be any child nodes afterwards
		boolean flag = false;
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			// if any of the child is not present, set the flag to true
			if(cur.left == null){
				flag =true;
			}else if (flag){
				//if flag is set but we still see cur has a left child,
				// the binary tree is not a completed one
				return false;
			}else{
				//if flag is not set and left child is present
				queue.offer(cur.left);
			}
			// same logic applied to the right child
			if (cur.right == nul){
				flag = true;
			}else if(flag){
				return false;
			}else{
				queue.offer(cur.right);
			}
		}
		return true;
	}

}
