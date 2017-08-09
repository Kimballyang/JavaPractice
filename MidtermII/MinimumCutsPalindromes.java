package MidtermII;

public class MinimumCutsPalindromes {
	public int minCuts(String input){
		//Assumptions: input is not null
		char[] array = input.toCharArray();
		int len = array.length;
		if(len == 0){
			return 0;
		}
		// isP[i][j] indicates if the substring (i-1,j-1) is palindrome
		boolean[][] isP = new boolean[len +1][len+1];
		//minCuts[i] indicates the min cuts for substring (0,i-1)
		int[] minCuts =new int[len+1];
		for(int end = 1; end<len; end++){
			// initialization of minCuts[end], we at most need end cuts
			//(separate all the characters)
			minCuts[end] =end;
			for (int start = end; start >= 1; start --){
				//calculate isP[start][end] first
				if(array[start-1] == array[end-1]){
					isP[start][end]= end -start <2 || isP[start+1][end-1];
				}
				//use isP[start][end] to calculate minCuts[end]
				if(isP[start][end]){
					minCuts[end]= Math.min(minCuts[end],1+minCuts[start -1]);
				}
			}
		}
		return minCuts[len]-1;
	}
	

}
