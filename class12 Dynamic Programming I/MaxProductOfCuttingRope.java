package laiofferClass12;

public class MaxProductOfCuttingRope {
	public int maxProduct(int length){
		//Assumptions: length>= 2.
		if (length == 2){
			return 1;
		}
		int[] array = new int[length +1];
		array[1]=0;
		array[2]=1;
		for (int i=3; i< array.length; i++){
			//At leaset one of the partitions after cutting is <= i/2.
			//so we can just pick that partition, and find the maximum product.
			for (int j= 1; j <= i/2; j++){
				//For the other partition, we can choose not cutting it or
				//cutting it, so the max number we can get is either i-j or array[i-j].
				array[i] = Math.max(array[i], j*Math.max(i-j, array[i-j]));
			}
		}
		return array[length];
	}

}
