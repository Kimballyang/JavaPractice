package laiofferClass25;

public class MaxWaterTrappedI {
	public int maxTrapped(int[] array) {
		//Assumptions: array is not null.
		if (array.length == 0) {
			return 0;
		}
		int left = 0;
		int right = array.length -1;
		int result = 0;
		int lmax = array[left];
		int rmax = array[right];
		while (left < right) {
			if  (array[left] <= array[right]) {
				result += Math.max(0,  lmax - array[left]);
				lmax = Math.max(lmax, array[left]);
				left++;
			} else {
				result += Math.max(0,  rmax - array[right]);
				rmax = Math.max(rmax, array[right]);
				right--;
			}
			
		}
		return result;
	}

}
