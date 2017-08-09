package laiofferClass27;

public class MajorityNumber {
	public int majority(int[] array){
		//Assumption: array is not null and is not emoty
		//majority number guarantees to exist.
		int candidate = array[0];
		int count = 1;
		for(int i = 1; i < array.length; i++){
			if(count == 0){
				count++;
				candidate = array[i];
			} else if(candidate == array[i]){
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}
}
