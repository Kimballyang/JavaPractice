package laiofferClass12;

public class LongestAscendingSubArray {
	public int longest(int[] array){
		//Assumptions: the given array is not null.
		if (array.length == 0){
			return 0;
		}
		//dp[i] = 1   (array[i] <= array[i-1])
		// = dp[i-1] +1 (array[i] >array[i-1])
		//so we can make the space consumption more efficient by only
		//recording the latest dp[i]
		int result = 1;
		int cur = 1;
		for (int i = 1; i < array.length; i++){
			if(array[i] > array[i-1]){
				//the second case, we can update dp[i].
				cur++;
				result = Math.max(result, cur);
				}else{
					//the first case, we need to reset dp[i]	
					cur = 1;
				}
			}
			return result;
		}
	}
	


