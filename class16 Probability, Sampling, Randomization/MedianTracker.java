package laiofferClass16;

import java.util.Collections;
import java.util.PriorityQueue;

//MedianTracker will call read() method to read the values one by one.

public class MedianTracker {
	private PriorityQueue<Integer> smallerHalf;
	private PriorityQueue<Integer> largerHalf;
	
	public MedianTracker(){
		//we care about the smallest number of the larger half and
		//largest number of the smaller half.
		//So for the smaller half we use a max heap and for the 
		// larger half we use a min heap.
		largerHalf = new PriorityQueue<Integer>();
		smallerHalf = new PriorityQueue<Integer>(11, Collections.reverseOrder());
	}
	
	public void read(int value){
		//we maintain the property:
		//size(smallerHalf) == size(largerHalf) when there are enven number of
		// values read, or size(smallerHalf) == size(largerHalf) +1, when
		// there are odd number of values read.
		if(smallerHalf.isEmpty() || value <= smallerHalf.peek()){
			smallerHalf.offer(value);
		}else{
			largerHalf.offer(value);
		}
		//After we insert the value,
		//only when size(smallerHalf) == size(largerHalf) +2 or
		//size(smallerHalf) == size(largerHalf) -1 will break the balance,
		//and we need to do the adjustment accordingly.
		if( smallerHalf.size() -largerHalf.size() >= 2){
			largerHalf.offer(smallerHalf.poll());
		}else if(largerHalf.size() > smallerHalf.size()){
			smallerHalf.offer(largerHalf.poll());
		}
	}
	
	public Double median(){
		int size = size();
		//By the property we maintained, it is easy to know that
		// if the number of values read is odd, the largest one in 
		// the smaller half is the median.
		if(size ==0){
			return null;
		}else if(size % 2 != 0){
			return(double)(smallerHalf.peek());
		}else{
			return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
		}
	}
	
	private int size(){
		return smallerHalf.size() + largerHalf.size();
	}

}
