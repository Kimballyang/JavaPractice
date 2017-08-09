package laiofferClass10;

public class SpiralGenerateI {
	//Method1: Recursive Generate
	public int[][] spiralGenerate(int n){
		// Assumptions: n>=0
		int[][] matrix = new int[n][n];
		if (n == 0){
			return matrix;	
		}
		recursiveGenerate(matrix,0,n,1);
		return matrix;
	}
	
	private void recursiveGenerate(int[][] matrix, int offset, int size, int num){
		//the base case is when there is only 0 or 1 element left.
		if(size == 0){
			return;
		}
		//do not forget this base case
		if(size ==1){
			matrix[offset][offset]=num;
			return;
		}
		for(int i =0; i<size-1; i++){
			matrix[offset+i][offset+size-1]=num++;
		}
		for(int i = 0; i< size -1; i++){
			matrix[offset + i][offset + size -1]= num++;
			
		}
		for(int i =size -1; i>=1; i--){
			matrix[offset + size -1][offset + i] =num++;
		}
		for(int i =size -1; i>= 1; i--){
			matrix[offset+i][offset]=num++;
		}
		recursiveGenerate(matrix,offset+1,size-2,num);
	}
	
	//Method 2: Iterative Generate.
	public int[][] spiralGenerateII(int n){
		//Assumptions: n >=0.
		int[][] matrix =new int[n][n];
		if(n==0){
			return matrix;
		}
		int start = 0;
		int end = n-1;
		int num = 1;
		//the base case is there is 0 or 1 element left.
		while (start <end){
			for (int i = start; i<= end; i++){
				matrix[start][i]=num++;
			}
			for(int i = start +1; i<= end -1; i++){
				matrix[i][end]= num++;
			}
			for(int i = end; i>= start; i--){
				matrix[end][i] = num++;
			}
			for(int i = end -1; i>=start+1; i--){
				matrix[i][start] =num++;
			}
			start++;
			end--;
		}
		//do not forget one of the base case is there is 
		//one element left
		if(start == end){
			matrix[start][end]= num++;
		}
		return matrix;
	}

}
