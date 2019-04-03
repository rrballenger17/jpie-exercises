// The Template Pattern is used to defer or delegate some or all steps of an algorithm to a subclass. 
// Common behavior can be defined in a superclass, and then specific variants are written in a sub- class. 

import java.util.*;


public class Stack {
	private final LinkedList<Integer> stack;

	public Stack() {
		stack = new LinkedList<>();
	}


	public Stack(final LinkedList<Integer> initialState) { 
		this.stack = initialState;
	}

	public boolean isEmpty(){
		return stack.isEmpty();
	}

	public void push(final int number) { 
		stack.add(0, number);
	}


	public Integer pop() { 
		return stack.remove(0);
	}


	public Stack filter(final StackPredicate filter) {
	
		final LinkedList<Integer> initialState = new LinkedList<>(); 
		
		for (Integer integer : stack) {
			if (filter.isValid(integer)) { 
				initialState.add(integer);
			} 
		}
		
		return new Stack(initialState); 
	}

}