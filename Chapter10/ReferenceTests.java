

	
import java.util.*;

import java.lang.ref.WeakReference;

import static org.junit.Assert.*;
import org.junit.*;

public class ReferenceTests{


	static class ValueContainer { 
		private final String value;
		
		public ValueContainer(final String value) { 
			this.value = value;
		}

		@Override
		protected void finalize() throws Throwable {
			super.finalize();
			System.out.printf("Finalizing for [%s]%n", toString()); 
		}

		@Override
		public boolean equals(Object other){

			if(other instanceof ValueContainer){
				ValueContainer o = (ValueContainer) other;

				return this.value.equals(o.value);

			}

			return false;

		}
		/* equals, hashCode and toString omitted */ 
	}


	@Test
	public void weakReferenceStackManipulation() {
		final WeakReferenceStack<ValueContainer> stack = new WeakReferenceStack<>();

		final ValueContainer expected = new ValueContainer("Value for the stack"); 
		

		stack.push(new ValueContainer("Value for the stack"));


		ValueContainer peekedValue = stack.peek(); 


		assertEquals(expected, peekedValue); 
		assertEquals(expected, stack.peek()); 


		peekedValue = null;
		System.gc();
		assertNull(stack.peek()); 
	}


	@Test
	public void addShudownHook() {
		Runtime.getRuntime().addShutdownHook(
			new Thread() { 
				@Override
				public void run() { 
					System.err.println("Shutdown hook activated");
				} 
			});
	}


}









