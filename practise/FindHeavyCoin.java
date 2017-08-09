package practise;

public class FindHeavyCoin {
	public static int findHeavyCoin(int[] array) {
        if ( array[0] + array[1] + array[2] + array[3] + array[4] == array[5] + array[6] + array[7] + array[8] + array[9]) {
        	return 11;
        } else if (array[0] + array[1] + array[2]+ array[3] + array[4] > array[5] + array[6] + array[7] + array[8] + array[9]) {
        		if( array[0] + array[1] == array[2]+ array[3]) {
        			return 5;
        			} else if ( array[0] + array[1] > array[2] + array[3]) {
        				return array[0] > array[1] ? 1 : 2;
        				} else {
                    	return array[2] > array[3] ? 3 : 4;
                    	}
        } else {
        	if ( array[5] + array[6] == array[7] + array[8]) {
        		return 10;
        		} else if (array[5] + array[6] > array[7] + array[8]){
        			return array[5] > array[6] ? 6 : 7;
        			} else {
        				return array[7] > array[8] ? 8 : 9;
        			}
        }
	}
	public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        int result = findHeavyCoin(array) + 1;
        System.out.println("The heavy coin is " + result);
	}

}
