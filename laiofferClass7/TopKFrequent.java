package laiofferClass7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	//Assumptions: combo is not, and K >= 1
	public String[] topKFrequent(String[] combo, int k ){
		// handle the special case of the empty combo at the very beginning 
		if (combo.length ==0){
			return new String[0];
		}
		// get all the distinct string  as keys and their frequencies
		// Notice: the freqMap has at least size 1
		Map<String, Integer> freqMap = getFreqMap(combo);
		// minHeap on the frequencies of the strings
		// notice using Map.Entry as the element type directly so that
		// operations are mostly efficient 
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
				new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String,Integer> e1, Map.Entry<String, Integer> e2){
			// compare the frequencies, directly call the compareTo method since 
			// the frequencies are represented by Integer
			return e1.getValue().compareTo(e2.getValue());
			
			}
		});
		for (Map.Entry<String, Integer> entry: freqMap.entrySet()){
			if (minHeap.size()<k){
				minHeap.offer(entry);
			}else if (entry.getValue() > minHeap.peek().getValue()){
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		//Since the returned array requires the strings sorted by their 
		// frequencies, use a separate helper method to do this operation
		return freqArray(minHeap);
	}
	private Map<String, Integer> getFreqMap(String[] combo){
		Map<String, Integer> freqMap= new HashMap<>();
		//Notice : when possible, choose the most efficient way for
		//HashMap operations
		for( String s: combo){
			Integer freq = freqMap.get(s);
			if (freq == null){
				freqMap.put(s, 1);
			}else{
				freqMap.put(s, freq+1);
			}
		}
		return freqMap;
	}
	
	private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap){
		String[] result = new String[minHeap.size()];
		for (int i= minHeap.size() -1; i>=0; i--){
			result[i] = minHeap.poll().getKey();
		}
		return result;
	}
	

}
