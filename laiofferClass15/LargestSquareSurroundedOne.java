package laiofferClass15;

public class LargestSquareSurroundedOne {
	public class LargestSquareSurroundedByOne {
		//Return the length of the largest square.
		public int largest(int[][] matrix){
			//Assumptions: matrix is not null, size of M* N, where M,N >=0
			//the elements in the matrix are either 0 or 1
			if(matrix.length ==0 || matrix[0].length ==0){
				return 0;
			}
			int result =0;
			int M = matrix.length;
			int N = matrix[0].length;
			//the longest left arm length ending at each position in the matrix.
			//we here apply a trick for ease of later processing:
			//left[i][j] is actually mapped to matrix[i-1][j-1],
			//this will reduced the corner case.
			int[][] left = new int[M+1][N+1];
			int[][] up = new int[M+1][N+1];
			for(int i=0; i<M; i++){
				for(int j = 0; j< N; j++){
					if(matrix[i][j]== 1){
						left[i+1][j+1] = left[i+1][j] +1;
						up[i+1][j+1] = up[i][j+1] +1;
						//the maximum length of a surrounded by 1 matrix with rightbottom
						//position at matrix[i][j] is determined by the min value of 
						//left[i+1][j+1] and up[i+1][j+1]
						//and we check one by one all the possible lengths if it can 
						//provide the actual matrix.
						//we only ned to check the longest left arm length of the rigthttop
						//cell and the longest up arm length of the leftbottom cell.
						for (int maxLength = Math.min(left[i+1][j+1], up[i+1][j+1]);
								maxLength >=1; maxLength--){
							if(left[i+2 -maxLength][j+1] >= maxLength && up[i+1][j+2-
							                                                     maxLength] >= maxLength){
								result = Math.max(result, maxLength);
								break;
							}
								
						}
					}
				}
			}
			return result;
		}
	}

}
