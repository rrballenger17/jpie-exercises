
import java.util.*;
import java.lang.ref.WeakReference;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class AtomicTests {

	@Test
	public void atomicSharedState() {
		
		final ExecutorService executorService = Executors.newCachedThreadPool();

		final AtomicCounter c = new AtomicCounter(); 

		executorService.execute(new CounterSetter(c));

		final int value = c.getNumber().incrementAndGet();

		assertEquals(1, value); 
	}


	static class AtomicCounter {

	private final AtomicInteger number = new AtomicInteger(0);

	public AtomicInteger getNumber() { 
		return number;
	} 

	}

	private static class CounterSetter implements Runnable { 

		private final AtomicCounter counter;

		private CounterSetter(AtomicCounter counter) { 
			this.counter = counter;
		}

		@Override
		public void run() {
		
			while(true) { 
				counter.getNumber().set(0);
			} 
		}

	} 
}

