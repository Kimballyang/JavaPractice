package laiofferClass16;

public class Random1000 {
	public int random1000(){
		while(true){
			//The following 4 lines of code is usually used to compute
			//a0*x^0 + a1*x^2 + a3*x^3 +....+ak*x^k
			int num = 0;
			for(int i = 0; i <5; i++){
				num = num * 5 + RandomFive.random5();
			}
			//choose 3000 instead of 1000 to reduce the # of expected random5() calls.
			if (num < 3000){
				return num % 1000;
			}
		}
	}

}
