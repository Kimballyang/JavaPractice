package practise;

public class OddOccurance {
	public static int findNum(int[] array) {
        if (array == null) {
                        //we assume that if no number appear odd times, return "-1"
                        return -1;
        }
        int res = 0;
        for (int i = 0; i < array.length; i++) {
                        res = res ^ array[i];
        }
        return res;
	}
	// we could take a array as a test. we assume array = [0,0,1,2,2,3,3,5,4,5,4]
	public static void main(String[] args) {
        int[] array = {0,0,1,1,2,2,3,3,5,4,5,4};
        System.out.println("The number that appears an odd number of times in the list is " + findNum(array));
	}

}
