package laiofferClass6;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthesesI {
	public List<String> validParentheses(int k){
		List<String> result = new ArrayList<String>();
		// the final sting contain 2k characters.
		char[] cur = new char[k*2];
		helper(cur, k, k,0,result);
		return result;	
	}
	// left: how many '(' we still have
	// right: how many ")" we still have
	// index: the current position in cur we want to fill in with either "(" or")"
	private void helper(char[] cur, int left, int right, int index, 
			List<String> result){
		// terminate condition
		// when we do not have any parentheses left.
		if(left== 0 && right == 0){
			result.add(new String(cur));
			return;
		}
		// when we can add a ')'? whenever there is some '(' we can still use
		if(left>0){
			cur[index]='(';
			helper(cur, left-1, right, index +1, result);
			// Notice: it looks like we do not do anything when back tracking
			// to the previous level
			// the code is still correct because:
			// 1. we are setting the character at index and when back tracking.
			// what we need is just 1).remove the character at index and
			// 2). add a different character at index
			// 2. only when we fill in all the positions in cur, we have a 
			// complete solution
			// the code itself actually already suffices the above two points and it
			// already does the correct removing operation when back tracked to
			// the previous level
			
		}
		// when we can add a ')' ? when there is more '(' than ')' used,
		// because each ')' should be associated with a previous'('.
		if(right > left){
			cur[index]=')';
			helper(cur,left,right-1,index+1,result);
		}
	}

}
