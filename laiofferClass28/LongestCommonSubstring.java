package laiofferClass28;

public class LongestCommonSubstring {
	public String longestCommon(String s, String t){
		//Assumptions: s, t, are not null
		char[] sa = s.toCharArray();
		char[] ta = t.toCharArray();
		
		//record the longest common subString's start position in s
		int start = 0;
		//record the longest common substring's length
		int longest = 0;
		int[][] common = new int[sa.length][ta.length];
		for(int i =0; i < sa.length; i++){
			for(int j = 0; j < ta.length; j++){
				if ( sa[i] == ta[j]){
					if(i==0 || j == 0){
						common[i][j] = 1;
					} else {
						common[i][j] = common[i -1][j -1] + 1;
					}
					if (common[i][j] > longest){
						longest = common[i][j];
						start = i - longest + 1;
					}
				}
			}
		}
		return s.substring(start, start + longest);
	}
	
}
