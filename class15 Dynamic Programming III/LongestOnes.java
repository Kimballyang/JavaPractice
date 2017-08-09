package laiofferClass15;

public class LongestOnes {
	public int longest(int[] array){
		//Assumptions: array is not null.
		int result = 0;
		int cur = 0;
		for(int i =0; i <array.length;i++){
			if(array[i] ==1){
				if(i ==0 || array[i-1] ==0){
					cur =1;
				}else{
					cur++;
				}
				result = Math.max(result, cur);
			}
		}
		return result;
	}

}
