package laiofferClass7;

public class RemoveDuplicateI {
	// try to convert the input to char[] and do it in place
	public String deDup(String input){
		if(input == null){
			return null;
		}
		char[] array = input.toCharArray();
		int end = 0;
		for (int i=0; i<array.length; i++){
			// repeated characters will be ignored except
			//for the first character in the sequence
			if (i==0 || array[i] != array[end-1]){
				array[end++]=array[i];
			}
		}
		return new String(array,0,end);
	}

}
