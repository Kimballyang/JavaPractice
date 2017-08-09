package laiofferClass1;

import java.util.Arrays;

/**
 * Search in sorted matrix, each row of the matrix is sorted in ascending order, and
 * the first element of the row is equals to or larger than the last element of 
 * previous row.
 * Return the position if the target is found, otherwise return {-1, -1}
 * @author Ziru
 *
 */
public class SearchInSortedMatrixI {
	// Assumptions: matrix is not null, and has size N*M where N>=0 and M>=0.
	// return {-1, -1} if not found.
	
	//method 1: find row first then find col.
	public int[] searchI(int[][] matrix, int target){
		int[] result = new int[] {-1,-1};
		if (matrix .length == 0 ||matrix[0].length == 0){
			return result;
		}
		// Find the possible row location for target.
		int row = findRow(matrix,0,matrix.length -1,target);
		if (row == -1){
			return result;
		}
		//Find the possible col location in the row for target
		int col = findCol(matrix[row], 0, matrix[row].length -1, target);
		if (col== -1){
			return result;	
		}
		result[0] = row;
		result[1] = col;
		return result;
	}
		
		// find the largest row with first element <= target.
		private int findRow(int[][] matrix, int up, int down, int target){
			while (up <=down){
				int mid = up + (down - up)/2;
				if (matrix[mid][0]> target){
					down = mid -1;
				}else {
					up = mid +1;
				}
			
			}
			return down;
		}
	
		// Classical binary search to find the col on the row
		private int findCol( int[] array, int left, int right, int target){
			while (left<= right){
				int mid = left+(right-left)/2;
				if (array[mid]== target){
					return mid;
				}else if (array[mid]< target){
					left = mid +1;
				}else{
					right = mid -1;
				}
			}
			return -1;
		}
		
		// Method 2 : convert the 2D array to 1D array and do binary search.
		public int[] search(int[][] matrix, int target){
			if (matrix.length == 0 || matrix[0].length ==0){
				return new int[]	{ -1, -1};
			}
			int rows = matrix.length;
			int cols = matrix[0].length;
			int left = 0;
			// convert the 2D array to 1 D array with row* cols elemnts.
			int right = rows * cols -1;
			while (left<= right){
				int mid = left+(right - left)/2;
				// convert the position in 1D array back to row and col in 2D array
				int row = mid/cols;
				int col = mid%cols;
				if (matrix[row][col]== target){
					return new int[]{row, col};
				}else if( matrix[row][col]<target){
					left = mid +1;
				}else{
					right = mid-1;
				}
			}
			return new int[] {-1,-1};
		}
		
		public static void main(String[] args){
			SearchInSortedMatrixI solution = new SearchInSortedMatrixI();
			int[][] matrix= new int[][] {{1,2,3},{4,5,6},{8,9,10}};
			int target = 9;
			int[] solu = solution.search(matrix,target);
			int[] soluI = solution.searchI(matrix, target);
			System.out.println(Arrays.toString(soluI));
			System.out.println(Arrays.toString(solu));
			
			
		}

}
