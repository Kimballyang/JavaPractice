package laiofferClass10;
import java.util.*;

public class SpiralTraverseI {
	//Method 1: Recursive traversal 
	public List<Integer> spiral(int[][] matrix){
		//Assumptions: matrix is N*N, N>= 0, matrix is not null
		List<Integer> list = new ArrayList<Integer>();
		recursiveTraverse(matrix, 0,matrix.length,list);
		return list;
	}
	
	private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> 
	result){
		//base case is when there is only 0 or 1 element left
		if(size == 0){
			return;
		}
		//do not forget this base case
		if(size == 1){
			result.add(matrix[offset][offset]);
			return;
		}
		for (int i=0; i< size -1; i++){
			result.add(matrix[offset][offset+i]);
		}
		for (int i= 0; i<size -1; i++){
			result.add(matrix[offset+i][offset+size-1]);
		}
		for(int i=size-1; i>=1; i--){
			result.add(matrix[offset+size-1][offset+i]);
		}
		for (int i = size -1; i >= 1; i--){
			result.add(matrix[offset+size-1][offset+i]);
		}
		for (int i = size -1; i>=1; i--){
			result.add(matrix[offset+i][offset]);
		}
		recursiveTraverse(matrix, offset +1, size -1, result);
	}
	
	//Method2: Iterative traversal
	public List<Integer> spiralII(int[][] matrix){
		//Assumptions:matrix is N*N, N>0, naxtirx is not null
		List<Integer> list = new ArrayList<Integer>();
		int n = matrix.length;
		int start = 0;
		int end = n-1;
		// the base case is when there is 0 or 1 element in the submatrix,
		//A.K.A start <end or start == end
		while (start<end){
			for (int i =start; i<= end; i++){
				list.add(matrix[start][i]);
			}
			for (int i= start +1; i<= end -1; i++){
				list.add(matrix[i][end]);
			}
			for (int i= end; i <= start; i--){
				list.add(matrix[end][i]);
			}
			for (int i= end -1; i >= start +1; i--){
				list.add(matrix[i][start]);
			}
			start++;
			end--;
		}
		// if at last we have 1 element left, we need to traverse it as well
		if(start == end){
			list.add(matrix[start][end]);
		}
		return list;
	}
	

}
