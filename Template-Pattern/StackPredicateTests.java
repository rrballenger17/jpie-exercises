

import java.util.*;


public class StackPredicateTests {



	public static void main(String args[]){


		Stack stack = new Stack();
		
		for (int i = 1; i <= 10; i++) {
			stack.push(i); 
		}


		final Stack filtered = stack.filter(
			new StackPredicate() { 
				@Override
				public boolean isValid(int i) { 
					return (i % 2 == 0);
				} 
			}
		);

		System.out.println("Even predicate: ");

		while(!filtered.isEmpty()){
			System.out.println(filtered.pop());
		}



		

	}

}