package laiofferClass4;

import java.awt.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class PreOrder {
	public List<Integer> preOrder(TreeNode root){
		List<Integer> preorder = new ArrayList<Integer>();
		if(root == null){
			return preorder;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offerFirst(root);
		while (!stack.isEmpty()){
			TreeNode cur = stack.pollFirst();
			// the left subtree should be traversed before right subtree, 
			// since stack is LIFO, we should push right into the stack first,
			// so for the next step the top element of the stack is the left subtree
			if (cur.right !=null){
				stack.offerFirst(cur.right);
			}
			if (cur.left!= null){
				stack.offerFirst(cur.left);
			}
			preorder.add(cur.key);
		}
		return preorder;
	}

}
