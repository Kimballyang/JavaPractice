package laiofferClass13;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWord {
	public boolean canBreak(String input, String[] dict){
		//Assumptions:
		//input is not null or empty.
		//dict is not null and dict is not empty.
		Set<String> dictSet = toSet(dict);
		//Notice: sometimes it will be handy to have such index matching,
		//canBreak[i] represents index (i-1) in input, also
		//can represent the substring(0,i).
		boolean[] canBreak = new boolean[input.length() +1];
		canBreak[0]=true;
		for (int i=1; i< canBreak.length; i++){
			for(int j= 0; j<i; j++){
				if(dictSet.contains(input.substring(j,i)) && canBreak[j]){
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[canBreak.length -1];
	}
	private Set<String> toSet(String[] dict){
		Set<String> set = new HashSet<>();
		for(String s : dict){
			set.add(s);
		}
		return set;
	}

}
