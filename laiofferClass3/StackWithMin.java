package laiofferClass3;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
	private Deque<Integer> stack;
	private Deque<Integer> minStack;
	
	public StackWithMin(){
		stack = new LinkedList<Integer>();
		minStack = new LinkedList<Integer>();
	}
	
	public Integer min(){
		if (minStack.isEmpty()){
			return null;
		}
		return minStack.peekFirst();
		
	}
	public void push(int value){
		stack.offerFirst(value);
		if(minStack.isEmpty() || value <= minStack.peekFirst()){
			minStack.offerFirst(value);
		}
	}
	
	public Integer pop(){
		if (stack.isEmpty()){
			return null;
		}
		Integer result = stack.pollFirst();
		//when the popped value is the same as top value of minStack, the value;
		// need to be popped from minStack as well
		if (minStack.peekFirst().equals(result)){
			minStack.pollFirst();
		}
		return result;
	}
	public Integer top(){
		if (stack.isEmpty()){
			return null;
		}
		return stack.peekFirst();
	}

}
