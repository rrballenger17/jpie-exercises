
import java.util.*;
import java.lang.ref.WeakReference;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.concurrent.*;

public class LockedSharedState{

	@Test
	public void lockedSharedState() {

		final ExecutorService executorService = Executors.newCachedThreadPool();

		final SimpleCounter c = new SimpleCounter(); 

		executorService.execute(new CounterSetter(c));

		synchronized (c) {
			c.setNumber(200); 
			assertEquals(200, c.getNumber());
		} 

	}


	public class SimpleCounter {

		private int number = 0;
		
		public void setNumber(int number) { 
			this.number = number;
		}

		public int getNumber() { 
			return number;
		} 
	}



	private static class CounterSetter implements Runnable { 
		
		private final SimpleCounter counter;
		private CounterSetter(SimpleCounter counter) { 
			this.counter = counter;
		}


		@Override
		public void run() {
			while(true) {
				synchronized (counter) {
					counter.setNumber(100); 
				}
			} 
		}

	}

}

