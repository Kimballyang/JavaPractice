package laiofferClass10;

public class AbbMatch {
	// method 1: Recursive way
	public boolean match(String input, String pattern){
		// Assumption: input, pattern are not null.
		return match(input, pattern,0,0);
	}
	private boolean match(String s, String t, int si, int ti){
		//only when we run out of s and t at the same time,
		// there is a match.
		if(si == s.length() && ti == t.length()){
			return true;
		}
		//if we run out of one of s and t but there is still some 
		// characters left for the other one, we can not find the match
		if(si >= s.length() || ti >= t.length()){
			return false;
		}
		//case 1. if the current character in t is not a digit.
		if (t.charAt(ti)<'0' || t.charAt(ti) > '9'){
			if(t.charAt(si) == t.charAt(ti)){
				return match(s,t,si+1, ti+1);
			}
			return false;
		}
		//cases 2. if the current character in t is a digit.
		//we need to find in total what is the number. 
		//e.g. "123" means number 123
		int count = 0;
		while (ti <t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9'){
			count = count * 10 +(t.charAt(ti) - '0');
			ti++;
		}
		return match(s,t,si+count, ti);
	}
	
	//Method2: Iterative way.
	//notice that ths above revursive solution is a TAIL recursion,
	//it is very easy to convert it to an iterative one
	public boolean matchII(String input, String pattern){
		//Assumptions: input, pattern are not null.
		int si = 0;
		int ti= 0;
		while(si < input.length() && ti< pattern.length()){
			if (pattern.charAt(ti) <'0' || pattern.charAt(ti) >'9'){
				if(input.charAt(si) != pattern.charAt(ti)){
					return false;
				}
				si++;
				ti++;
			}else{
				int count = 0;
				while (ti < pattern.length() && pattern.charAt(ti)>='0' &&
						pattern.charAt(ti) <= '9'){
					count = count * 10 + (pattern.charAt(ti)-'0');
					ti++;
				}
				si += count;
			}
		}
		return si == input.length()&& ti == pattern.length();
	}
	

}
