package laiofferClass16;
// This class will be used as a reader and it read each of
// the element by calling the read() method.
// by calling the sample() method, it will return the sample
// of whatever read before.

public class ReservoirSampling {
	//how many numbers have been read so far.
	private int count;
	//only need to maintain the current sample.
	private Integer sample;
	
	public ReservoirSampling(){
		//initialization, count is initialized as 0 since there is
		//no single number read at the beginning.
		this.count = 0;
		this.sample = null;
		
	}
	
	public void read(int value){
		count++;
		int prob = (int)(Math.random() * count);
		//the current read value has the probability of 1 /count to be as the
		//current sample.
		if(prob ==0){
			sample = value;
		}
	}
	
	public Integer sample(){
		return sample;
	}
	
	

}
