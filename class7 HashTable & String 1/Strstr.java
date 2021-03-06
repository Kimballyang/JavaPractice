package laiofferClass7;
/**
 * Notice: 
 * 1. There is no assumption about the charset used in the String
 *    so that we can not assume we are using 26 lower case characters
 * 2.This is the most correct version of RabinKarp in computer programming,
 *   we need to handle 1. we could use arbitrary charset, 2. the overflow 
 *   caswe,
 *   by taking the module operation on a very large number
 *  3. you probably do not need to write this kind of solution to handle 
 *  above two cases, if you are in an interview. But it is still necessary 
 *  to understand the reason behind it.
 *    
 * @author Ziru
 *
 */

public class Strstr {
	//Method 1. naive solution
	
	public int strstrI(String large, String small){
		if (large.length() < small.length()){
			return -1;
		}
		// return 0 if small is empty
		if (small.length() == 0){
			return 0;
		}
		for(int i= 0; i<= large.length() - small.length(); i++){
			if(equals(large,i,small)){
				return i; 
			}
		}
		return -1;
	}
	// method 2: RabinKarp
	public int strstrII(String large, String small){
		if(large.length() <  small.length()){
			return -1;
		}
		//return 0 if small is empty
		if (small.length() == 0){
			return 0;
		}
		//we need to a large prime as module end.
		int largePrime =101;
		// we also need a small prime to calculate the hash value
		// (since the charset would be very large,e.g. 1, 112,064 for using UTF
		// we can not use that number).
		int prime = 31;
		int seed = 1;
		// hash value is calculated using the smallPrime and taken the module
		//operation on largePrime.
		//has =(s0*smallP^k +s1*smallP^(k-1)+...+sk*smallP^0)%largeP
		//hash = (s0*smallP^k +s1*smallP^(k-1) +..+sk*(smallP^0)%largeP
		int targetHash = small.charAt(0) % largePrime;
		for (int i =1; i<small.length(); i++){
			seed = moduleHash(seed,0,prime,largePrime);
			targetHash = moduleHash(targetHash, small.charAt(i),prime, largePrime);
		}
		int hash = 0;
		for (int i = 0; i < small.length(); i++){
			seed = moduleHash(seed,0,prime,largePrime);
			targetHash = moduleHash(targetHash,small.charAt(i), prime,largePrime);
			
		}
		if (hash == targetHash && equals(large, 0, small)){
			return 0;
		}
	
		for(int i =1; i<= large.length() -small.length(); i++){
			//we need to make sure the module number is non-negative
			hash= nonNegative(hash - seed * large.charAt(i-1)% largePrime,largePrime);
			hash = moduleHash(hash,large.charAt(i+small.length() -1), prime,largePrime);
			//Notice: if the hash matches, it does not mean we really find a
			// substring match.
			// Because ther is collision, we need to check if the substring really
			// matches the small string
			//on average, this will not increase the time complexity, the probability
			// of collision is O(1)	 so we still haveO(N+M)
			if(hash ==  targetHash && equals(large,i,small)){
				return i;
			}
		}
		return -1;
	}
	
	public boolean equals(String large, int start, String small){
		for (int i=0; i< small.length(); i++){
			if (large.charAt(i+start) != small.charAt(i)){
				return false;
			}
		}
		return true;
	}
	
	public int moduleHash(int hash, int addition, int prime, int largePrime){
		return (hash*prime % largePrime + addition)% largePrime;
	}
	
	public int nonNegative(int hash, int largePrime){
		if(hash < 0){
			hash += largePrime;
		}
		return hash;
	}

}
