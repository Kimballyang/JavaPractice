package laiofferClass16;

import java.util.List;

public class NinetyFivePercentile {
	public int percentile95(List<Integer> lengths){
		//Assumptions: lengths is not null and size >=1 without
		//and null values.
		//The length of possible longest url is 4096.
		int[] count = new int[4097];
		for(int len : lengths){
			count[len]++;
		}
		int sum = 0;
		int len = 4097;
		while(sum <= 0.05 * lengths.size()){
			sum += count[--len];
		}
		return len;
	}

}
