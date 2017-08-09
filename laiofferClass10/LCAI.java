package laiofferClass10;

import javax.swing.tree.TreeNode;

public class LCAI {
	//return:
	// null - there is no one or two in the subtree
	//non null
	//1). if there is only one node of one/two in the subtree,
	//  just return the one/two itself
	// 2). if there both one/two are in the subtree, return the LCA
	// a). one is two's descendant, return one.
	// b). two is one's descendant, return two.
	// c). otherwise, return the lowest node with one and two in the 
	// two different subtrees.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two){
		//Assumptions: root is not null,
		//one and two guaranteed to be in the tree and not null
		if(root == null){
			return null;
		}
		// if root is one or two, we can ignore the later recursions.
		if(root == one || root == two){
			return root;
		}
		TreeNode ll = lowestCommonAncestor(root.left,one,two);
		TreeNode lr = lowestCommonAncestor(root.right, one, two);
		if(ll != null && lr != null){
			return root;
		}
		return ll == null ? lr: ll;
	}

}
