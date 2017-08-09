package laiofferClass18;

public class MoveZeroII {
	public int[] moveZero(int[] array){
		//Assumptions: array is not null
		if (array.length <= 1){
			return array;
		}
		//the slow pointer is not included in the non-zero subarray.
		int end = 0;
		for (int i = 0; i <array.length; i++){
			if(array[i] != 0){
				array[end++] =array[i];
				
			}
		}
		//fill in the right part with 0.
		for (int i = end; i<array.length; i++){
			array[i] = 0;
		}
		return array;
	}

}
