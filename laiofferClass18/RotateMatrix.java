package laiofferClass18;

public class RotateMatrix {
	
//Method 1: split into levels and for each level split it into
	//four partitions.
	public void rotate(int[][] matrix){
		//Assumptions; matrix is not null and has size of N*N, N>=0.
		int n = matrix.length;
		if(n <=1){
			return;
		}
		int round = n/2;
		for(int level = 0; level < round; level++){
			int left = level;
			int right = n -1 -level;
			for(int i = left; i <= right; i++){
				int tmp = matrix[left][i];
				matrix[left][i] = matrix[n-1-i][left];
				matrix[n -1 -i][left] = matrix[n-1-left][n-1-i];
				matrix[n-1-left][n-1-i] = matrix[i][n-1-left];
				matrix[i][n-1-left] = tmp;
			}
		}
	}
	
	//Method 2: Rotate a point by 90 degree clockwise ==
	//1. Mirror the point according to y axis, then
	//2. Mirror the point according the line of y= x.
	public void rotateII(int[][] matrix){
		int n = matrix.length;
		if(n<=1){
			return;
		}
		mirrorY(matrix,n);
		mirrorYEX(matrix,n);
	}
	
	//mirror the point by y axis.
	private void mirrorY(int[][] matrix, int n){
		for(int i = 0; i <n; i++){
			for(int j= 0; j<n/2; j++){
				swap(matrix, i, j,i,n-1-j);
				
			}
		}
	}
	//mirror the point by the line of y=x
	private void mirrorYEX(int[][] matrix, int n){
		for(int i=0; i<n; i++){
			for(int j =0;j+i <n-1;j++){
				swap(matrix,i,j,n-1-j,n-1-i);
			}
		}
	}
	
	private void swap(int[][] matrix, int iRow, int iCol, int jRow, int jCol){
		int tmp = matrix[iRow][iCol];
		matrix[iRow][iCol] =matrix[jRow][jCol];
		matrix[jRow][jCol] = tmp;
	}
	

}
