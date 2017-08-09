package laiofferClass12;

public class ArrayHopperI {
	//Method 1： DP, canJump[i] means from index 0, can jump to index i.
	public boolean canJump(int[] array){
		boolean[] canJump = new boolean[array.length];
		canJump[0] = true;
		for (int i=1; i<array.length; i++){
			for(int j= 0; j<i; j++){
				//if index j is reachable from index 0, and from index j
				// it is possible to jump to index i.
				if(canJump[j] && array[j] +j >= i){
					canJump[i] = true;
					break;
				}
			}
		}
		return canJump[array.length -1];
	}
	// Method2: Dp, canJump[i] means from index i,
	//can jump to index array.length -1.
	public boolean canJumpII(int[] array){
		//Assumptions: array is not null and is not empty.
		if(array.length == 1){
			return true;
		}
		boolean[] canJump = new boolean[array.length];
		for (int i = array.length -2; i >= 0; i--){
			//if from index i, it is already possible to jump
			//to the end of the array.
			if(i+array[i] >= array.length -1){
				canJump[i] = true;
			}
			else{
				for (int j = array[i]; j>=1; j--){
					if (canJump[j+i]){
						canJump[i]= true;
						break;
					}
					
				}
			}
		}
	
	return canJump[0];
	}
	
	
//Method 3: Greedy solution.
//Keep the max index reachable by jumping x steps, and
//the max index reachable by jumping x+1 steps.
	public boolean canJumpIII(int[] array){
		//Assumptions: array is not null and array.length >= 1.
		if(array.length == 1){
			return true;
		}
		//the max index jumping current steps can reach.
		int cur = 0;
		//the max index jumping current +1 steps can reach.
		int next = 0;
		for(int i=0; i< array.length; i++){
			if(i>cur){
				//if o>cur, we can not use current steps to jump to i.
				if(cur == next){
					//cur == next means there is no progress for 
					//using current +1 jump steps, if that is the case,
					//we can never reach end of array.
					return false;
				}
				cur = next;
			}
			//update the max index jumping one more step can reach.
			next = Math.max(next, i+array[i]);
		}
		return true;
	}
}
	
	
