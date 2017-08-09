package laiofferClass1;

public class FibonacciNumber {
	public long fibonacci(int k ){
		if (k <= 0 ){
			return 0;
		}
		if (k== 1){
			return 1;
		}
		return fibonacci(k-1) + fibonacci(k-2);
	}
	// method 2: dp solution with O(n) space
	public long fibonacciI(int K){
		if (K<= 0){
			return 0;
		}
		long[] array = new long[K+1];
		array[1]=1;
		for (int i =2; i <= K; i++){
			array[i] = array[i-2]+array[i-1];
		}
		return array[K];
	}
	
	//method 3 : dp solution with O(1) space
	public long fibonacciII(int K){
		long a =0;
		long b = 1;
		if (K <=0){
			return a;
		}
		while (K> 1){
			long temp = a+b;
			a=b;
			b= temp;
			K--;
		}
		return b;
	}
	
	//method 4: O(logn) solution using matrix multiplication
	//M= {{1,1},{1,0}} = {{f(2), f(1)},{f(1),f(0)}}
	//fibo(K)= (M^K)[0][0]
	public static final long[][] SEED = { {1L, 1L},{1L,0L}};
	
	public long fibonacciIII(int K){
		if (K<=0){
			return 0;
		}
		if (K==1){
			return 1;
		}
		long[][] matrix = {{ 1L, 1L}, { 1L,0L}};
		pow(matrix,K-1);
		return matrix[0][0];
		
	}
	private void pow(long[][] matrix, int pow){
		if (pow ==1){
			return;
		}
		pow(matrix,pow /2);
		multiply(matrix, matrix);
		if (pow %2 !=0){
			multiply(matrix,SEED);
		}
	}
	
	private void multiply(long[][] matrix, long[][] multiplier){
		long topLeft = matrix[0][0]* multiplier[0][0] +matrix[0][1]* multiplier[1][0];
		long topRight = matrix[0][0]* multiplier[0][1]+matrix[0][1]* multiplier[1][1];
		long bottomLeft = matrix[1][0]*multiplier[0][0]+ matrix[1][1]* multiplier[1][0];
		long bottomRight = matrix[1][0]* multiplier[0][1]+ matrix[1][1]* multiplier[1][1];
		matrix[0][0] = topLeft;
		matrix[0][1] = topRight;
		matrix[1][0] = bottomLeft;
		matrix[1][1] = bottomRight;
	}
	
	//main 
	public static void main(String[] args){
		FibonacciNumber solution = new FibonacciNumber();
		
		int k= 6;
	    long sol = solution.fibonacci(k);
		System.out.println(k+"th fibonacci number is "+sol);
	}
}
