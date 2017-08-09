package laiofferClass7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Assumptions: there could be duplicated elements in the given arrays
public class CommonNumbersII {
	// Method1: two pointers
	public List<Integer> commonI(int[] a, int[] b){
		//Assumption: a, b is not null
		List<Integer> common = new ArrayList<Integer>();
		int i = 0;
		int j= 0;
		while(i<a.length && j<b.length){
			if (a[i] == b[j]){
				common.add(a[i]);
				i++;
				j++;
			}else if(a[i]<b[j]){
				i++;
			}else{
				j++;
			}
		}
		return common;
	}
	//method2: use HashMap
	public List<Integer> commonII(int[] a, int[] b){
		List<Integer> common = new ArrayList<Integer>();
		HashMap<Integer,Integer> countA =new HashMap<Integer, Integer>();
		for (int num :a){
			Integer ct= countA.get(num);
			if(ct != null){
				countA.put(num,ct+1);
			}else {
				countA.put(num, 1);
			}
		}
		HashMap<Integer,Integer> countB = new HashMap<Integer, Integer>();
		for (int num : b){
			Integer ct = countB.get(num);
			if(ct !=null){
				countB.put(num,ct +1);
			}else{
				countB.put(num,  1);
			}
		}
		for (Map.Entry<Integer,Integer> entry: countA.entrySet()){
			Integer ctIntB = countB.get(entry.getKey());
			if(ctIntB !=null){
				int appear = Math.min(entry.getValue(),ctIntB);
				for (int i=0; i<appear;i++){
					common.add(entry.getKey());
				}
			}
		}
		return common;
		
	}

}
