package laiofferClass18;

import java.util.ArrayList;
import java.util.List;

public class LargestAndSecondLargest {
	//The element class will be used to store the original value
	// in the array and all the values compared to it.
	static class Element{
		int value;
		List<Integer> compredValues;
		
		Element(int value){
			this.value = value;
			this.compredValues = new ArrayList<>();
		}
	}
	
	public int[] largestAndSecond(int[] array){
		//Assumptions: array is not null, array.length >= 2.
		//Convert the original array to Element array.
		Element[] helper= convert(array);
		//largerLength is the left partition's length containning the
		//larger values after each round of comparision.
		//for each round, the comparison is still doing for each of
		// the indices pairs (i, largerLength -1 - i). 
		//so that the larger elements are always on the left side,
		//and the largerLength will be cut in half each round.
		//largerLength is obviously initiated by the array's length.
		int largerLength = array.length;
		//we will terminate when there is only one element left on 
		//the larger partition, and it has to be the largest value.
		//the second largest value is the largest value in its
		//compared values.
		while(largerLength >1){
			compareAndSwap(helper,largerLength);
			largerLength = (largerLength +1)/2;
		}
		return new int[] {helper[0].value,largest(helper[0].compredValues)};
	}
	private Element[] convert(int[] array){
		Element[] helper = new Element[array.length];
		for(int i = 0; i<array.length; i++){
			helper[i] = new Element(array[i]);
		}
		return helper;
	}
	//Compare each of the indice pairs (i, largerLength -1- i),
	//swap the larger values on the left side is necessary,
	//and put the smaller value into the larger value's compare values list.
	private void compareAndSwap(Element[] helper, int largerLength){
		for (int i = 0; i < largerLength /2; i++){
			if (helper[i].value < helper[largerLength - 1 - i].value){
				swap(helper, i, largerLength - 1- i);
			}
			helper[i].compredValues.add(helper[largerLength -1 -i].value);

		}
		
	}
	private void swap(Element[] helper, int left, int right){
		Element tmp = helper[left];
		helper[left] = helper[right];
		helper[right]= tmp;
	}
	
	private int largest(List<Integer> list){
		//This is guaranteed to be O(1)
		int max = list.get(0);
		//Using Iterator is guaranteed to be O(1) traversing each of the 
		//element in the list.
		for(int num: list){
			max = Math.max(max, num);
		}
		return max;
	}

}
