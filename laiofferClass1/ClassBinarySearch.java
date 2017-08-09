package laiofferClass1;

public class ClassBinarySearch{

	public int binarySearch(int[] array, int target){
		if (array == null || array.length == 0){
			return -1;
		}
		int left = 0; 
		int right = array.length - 1;
		while (left <= right){
			int mid = left +( right -left)/2;
			if (array[mid] == target){
				return mid;
				
			}else if (array[mid] < target){
				left = mid +1;
			}else{
				right = mid -1;
			}
		}
		return -1;
	}
	//main
	public static void main(String[] args){
		int[] array = new int[] {2, 3, 4, 5, 6, 7, 9};
		int target= 5;
		ClassBinarySearch solution = new ClassBinarySearch();
		int solu = solution.binarySearch(array, target);
		System.out.println("target index in the array is "+solu);
		
	}
}
