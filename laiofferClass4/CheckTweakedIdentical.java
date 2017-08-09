package laiofferClass4;

public class CheckTweakedIdentical {
	public boolean isTweakedIdentical(TreeNode one, TreeNode two){
		if (one== null && two == null){
			return true;
		}else if (one == null || two == null){
			return false;
		}else if (one.key != two.key){
			return false;
		}
		return isTweakedIdentical(one.left, two.left)&& isTweakedIdentical(one.right,
				two.right)
				|| isTweakedIdentical(one.left,two.right)&& isTweakedIdentical(one.right,
						two.left);
	}

}
