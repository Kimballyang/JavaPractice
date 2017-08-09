package laiofferClass28;

public class LongestCommonSubSequence {
	public int longest(String s, String t){
		// Assumptions: s, t are not null
		// using the trick of "add 1" index, will make the base case
		//easier to handle, e.g. the 0th row and the 0th column will
		// be zero
		int[][] longest = new int[s.length() + 1][t.length() + 1];
		for (int i = 1; i <= s.length(); i++){
			for(int j = 1; j <= t.length(); j++){
				if (s.charAt(i -1) == t.charAt(j - 1)){
					longest[i][j] = longest[i -1][j -1] + 1;
				} else {
					longest[i][j] = Math.max(longest[i -1][j], longest[i][j -1]);
				}
			}
		}
		return longest[s.length()][t.length()];
	}

}
