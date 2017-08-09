package laiofferClass7;

public class RemoveDuplicateIV {
	public String deDup(String input){
		if(input == null || input.length() <= 1){
			return input;
		}
		//try to convert the string to char[], and do it in place
		char[] array = input.toCharArray();
		// instead of using a extra stack explicitly, we can actually
		// reuse the left side of the origianl char[] as the "stack"
		// end : is where the top of the stack is .
		int end =0 ;
		for(int i= 1; i< array.length; i++){
			//if the stack is empty(when end==-1) or there is no duplicate characters,
			// we are able to push the character into the stack
			if (end == -1 || array[i] != array[end]){
				array[++end]= array[i];
			}else{
				//otherwise, we need pop the top element by end--
				// and ignore all the consecutive duplicate chars
				end--;
				while(i+1<array.length && array[i] == array[i+1]){
					i++;
				}
			}
		}
		return new String(array,0,end+1);
	}

}
