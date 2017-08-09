package laiofferClass11;

public class PowerOfTwo {
	//Method 1.
	public boolean isPowerOfTwo(int number){
		if(number <= 0){
			return false;
		}
	// ignore all the trailing 0's 
		while((number & 1) == 0){
			number >>>= 1;
		}
		//check if the number is 1 at end.
		return number == 1;
		
	}
	
	//method 2.
	public boolean isPowerOfTwoII(int number){
		if (number <= 0){
			return false;
		}
		//count the number of 1's
		int count = 0;
		while (number > 0){
			count += number & 1;
			number >>=1;
		}
		//for a number of power of 2, there should be only one 1.
		return count == 1;
	}
	
	//method 3
	public boolean isPowerOfTwoIII(int number){
		//use the trick of number & (number -1) will remove the rightmost 1.
		return number > 0 && (number & (number -1)) ==0;
	}
	

}
