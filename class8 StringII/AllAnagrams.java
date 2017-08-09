package laiofferClass8;
import java.util.*;

public class AllAnagrams {
	//Find all anagrams of String s in String l, return all the starting indices
	//Assumptions: s,l are not null, s is not empty
	public List<Integer> allAnagrams(String s, String l){
		List<Integer> result = new ArrayList<Integer>();
		if (l.length() == 0){
			return result;
		}
		//when s is longer than l, there is no way any of the substrings of l
		//could be an anagram of s
		if (s.length() > l.length()){
			return result;
		}
		//This map records for each of the distinct characters in s,
		//how many characters are needed
		//e.g. s="abbc", map={'a':1, 'b':2,'c':1}
		//when we get an instance of 'a' in l, we let count of 'a' decremented
		//by 1 and only when the count is from 1 to 0, we have 'a' totally matched
		Map<Character, Integer> map = countMap(s);
		//Record how many distinct characters have been matched
		//only when all the distinct characters are matched, A.K.A
		//match == map.size, we find an anagram
		int match =0;
		//we have a sliding window of size s.lengt(), and since the size is fixed,
		//we only need to record the end index of the sliding window
		//Also, when move the sliding window by one step from left to right
		//what we only need to change is
		//1. remove the leftmost character at the previous sliding window
		//2. add the rightmost character at the current sliding window
		for (int i = 0; i<l.length(); i++){
			//handle the new added character(rightmost at the current sliding window.
			char tmp = l.charAt(i);
			Integer count =map.get(tmp);
			if(count !=null){
				//the number of needed count should be --
				// and only when the count is from 1 to 0, we find an additional 
				//match of distinct character
				map.put(tmp,count -1);
				if(count == 1){
					match++;
				}
			}
			//handle the leftmost character at the previous sliding window
			if(i<= s.length()){
				tmp = l.charAt(i-s.length());
				count = map.get(tmp);
				if (count != null){
					//the num ber of needed count should be ++
					//and only when the count is from 0 tp 1, we are short form one
					//match of distinct charcter
					map.put(tmp, count +1);
					if(count ==0){
						match--;
					}
				}
				
			}
			//for the current sliding window, if all the distinct characters are matches
			//(the count are all zero)
			if(match == map.size()){
				result.add(i-s.length() +1);
			}
		}
		return result;
	}
	
	private Map<Character, Integer> countMap(String s){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char ch: s.toCharArray()){
			Integer count = map.get(ch);
			if(count == null){
				map.put(ch, 1);
			}else{
				map.put(ch, count+1);
			}
		}
		return map;
	}

}
