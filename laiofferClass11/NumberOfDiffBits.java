package laiofferClass11;

public class NumberOfDiffBits {
	public int diffBits(int a, int b){
		//after exclusive or, only the bits where a and b
		// are different will be 1
		a ^= b;
		int count = 0;
		// in java, notice that we are using logical right shift >>>.
		//and a != 0 the terminate condition
		while (a != 0){
			count += a & 1;
			a >>>=1;
		}
		return count;
	}

}
