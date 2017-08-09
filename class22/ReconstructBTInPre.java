package laiofferClass22;

public class ReconstructBTInPre {
	//Method1: Utilizing the inOrder sequence to determine
	// the size of left/right subtree
	public TreeNode reconstruct(int[] in, int[] pre){
		//Assumptions: pre, in are not null, there is no duplicates
		// in the binary tree, the length of pre an in are guaranteed
		// to be the same.
		Map<Integer, Integer> inIndex = indexMap(in);
		return helper(pre, inIndex, 0, in.length -1, 9, pre.length -1);
	}
	
	private Map<Integer, Integer> indexMap(int[] in) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++){
			map.put(in[i], i);
		}
		return map;
	}
	
	private TreeNode helper(int[] pre, Map<Integer, Integer> inIndex, int inLeft, int
			inRight, int preLeft, int preRight){
		if (intLeft > inRight){
			return null;
		}
		TreeNode root = new TreeNode(pre[preLeft]);
		//get the position of the root in inOrder sequence, so that we will know
		// the size of left/right subtrees.
		int inMid = inIndex.get(root.key);
		root.left = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid 
				- inLeft);
		root.right = helper(pre, inIndex, inMid +1, inRight, preRight + inMid - inRight
				+ 1, preRight);
		return root;
	}
	
	// Method 2: Another Linear Solution with traversing and constructing
	// the binary tree using preOrder and inOrder at the same time
	public TreeNode reconstructII(int[] in, in[] pre){
		//Assumptions: pre, in are not null, there is no duplicates
		// int the binary tree, the length of pre an in are guaranteed
		// to be the same
		int[] preIndex = new int[] {0};
		int[] inIndex = new int[] {0};
		return helperII(pre, in, preIndex, inIndex, Integer.MAX_VALUE);
	}
	private TreeNode helperII(int[] pre, int[] in, int[] preIndex, int[] inIndex, int target){
		// Traversing and construct the binary tree using preOrder and inOrder
		// the preOrder is [root][left subtree][right subtree]
		//from the preOrder, we know the root of the binary tree, 
		// the inOrder is [left subtree][root][right subtree]
		// when we know the root, we actually know the boundary of
		// the left/right subtree
		// the "target" is actually the root, and we are using inOrder
		//to identify the boundary of left subtree.
		if (inIndex[0] >= in.length || in[inIndex[0]] == target){
			return null;
		}
		TreeNode root = new TreeNode(pre[preIndex[0]]);
		//preOrder, advance the index by 1 since we already finish the root.
		preIndex[0] ++;
		root.left = helperII(pre, in, preIndex, inIndex, root.key);
		//inOrder, after finish the left subtree, we can advance the index by 1.
		inIndex[0]++;
		root.right = helperII(pre, in, preIndex, inIndex, target);
		return root;
	}
}
