package laiofferClass18;

public class LCAII {
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two){
		int l1 = length(one);
		int l2 = length(two);
		//This is a small trick that can guarantee when calling mergeNode(),
		//the first list is the shorter list, the second list is the longer one.
		if(l1 <= l2){
			return mergeNode(one, two, 12-l1);
		}else{
			return mergeNode(two,one, l1-l2);
		}
	}
	
	private TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff){
		while(diff >0){
			longer = longer.parent;
			diff--;
		}
		while (longer != shorter){
			longer = longer.parent;
			shorter = shorter.parent;
		}
		return longer;
	}
	//get the length of the list from the node to the root of the tree
	//along the path using parent pointers.
	private int length(TreeNodeP node){
		int length = 0;
		while(node != null){
			length++;
			node = node.parent;
		}
		return length;
	}

}
