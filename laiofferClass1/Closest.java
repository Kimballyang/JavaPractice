package laiofferClass1;

public class Closest {
	public int closest(int[] array, int target){
		if (array ==null || array.length ==0){
			return -1;
		}
		int left = 0;
		int right = array.length -1;
		while (left < right -1){ 
			int mid = left + (right - left)/2;
			if (array[mid]==target){
				return mid;
			}else if(array[mid]<target){
				left = mid;
			}else{
				right= mid;
			}
		}
		if (Math.abs(array[left]-target)<=Math.abs(array[right]-target)){
			return left;

		}
		return right;
	}
	public static void main(String[] args){
		Closest solution = new Closest();
		int[] array = { 1, 2, 3, 4, 5, 8, 9};
		int target = 6;
		int solu = solution.closest(array,target );
		System.out.println(array[solu]);
		
	}
}
