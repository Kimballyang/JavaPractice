package laiofferClass8;

public class RightShift {
	// Assumption: input is not null, n>=0
	public String rightShift(String input,int n){
		if(input.length() <= 1){
			return input;
		}
		char[] array = input.toCharArray();
		n %= array.length;
		reverse(array,array.length -n, array.length -1);
		reverse(array,0,array.length - n - 1);
		reverse(array,0,array.length -1);
		return new String(array);
	}
	
	private void reverse(char[] array, int left, int right){
		while(left<right){
			char tmp = array[left];
			array[left]= array[right];
			array[right]= tmp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args){
		RightShift solution = new RightShift();
		int n =2;
		String input = new String("hello");
		String solu = solution.rightShift(input, n);
		System.out.println(solu);
	}

}
