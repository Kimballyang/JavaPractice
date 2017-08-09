package laiofferClass99;

import java.util.ArrayList;
import java.util.List;

public class LargestSumOfVailidNumbers {
	public int largestSum(int[][] matrix){
		// Assumption: matrix is not null, 8*8
		int k = 8;
		List<Integer> configs = validConfigs(k);
		int[][] largest = new int[k][configs.size()];
		for(int i = 0; i<k; i++){
			//dp[i][j] = max(dp[i - 1][k] for all possible configuration k
			// that does not have conflict with configuration j
			for (int j = 0; j < configs.size(); j++){
				largest[i][j] = Integer.MIN_VALUE;
				if(i==0){
					largest[i][j] = sum(matrix[i], configs.get(j));
				} else{
					for(int l = 0; l < configs.size(); l++){
						if(noConflict(configs.get(j), configs.get(l))){
							largest[i][j] = Math.max(largest[i][j], largest[i - 1][l] +
									sum(matrix[i], configs.get(j)));
						}
					}
				}
			}
		}
		int result = largest[k -1][0];
		for (int i = 1; i < configs.size(); i++){
			result = Math.max(result,  largest[k - 1][i]);
		}
		return result;
	}
	
	private List<Integer> validConfigs(int k){
		List<Integer> configs = new ArrayList<Integer>();
		helper(configs, 0, k, 0);
		return configs;
	}
	
	private void helper(List<Integer> configs, int index, int k, int cur){
		configs.add(cur);
		for(int i = index; i < k; i++){
			helper(configs, i + 2, k, cur | (1 <<i));
		}
	}
	
	private boolean noConflict(int c1, int c2){
		return (c1 & c2) == 0 && ((c1 << 1) & c2) == 0 &&(c1 & (c2 << 1)) == 0;
	}
	
	private int sum (int[] array, int config){
		int sum = 0;
		for (int i = 0; i < array.length; i++){
			if(((config >>> i) & 1) != 0){
				sum += array[i];
			}
		}
		return sum;
	}
}
