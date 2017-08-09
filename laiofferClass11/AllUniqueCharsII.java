package laiofferClass11;
/**
 * Determine if the letters in a word are all unique
 * Assumption: 
 * we are using ASCII encoding and the number of valid letters
 * is 256, encoded from 0 to 255
 * The input word is not null
 * @author Ziru
 *
 */
public class AllUniqueCharsII {
	public boolean allUnique(String word){
		//each int value can represent 32 bit,so we need 8 ints
		//to represent 256 bits
		int[] vec = new int[8];
		char[] array = word.toCharArray();
		for (char c : array){
			//for a value c in the range of 0-255,
			//it is actually mapped to the int value at c/32 as index,
			//and the c%32'th bit of the int value
			if((vec[c/32] >>> (c % 32) & 1) != 0){
				return false;
			}
			vec[c/32] |= 1 << (c%32);
		}
		return true;
	}
	

}
