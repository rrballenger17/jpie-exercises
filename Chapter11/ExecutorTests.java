
	
import java.util.*;

import java.lang.ref.WeakReference;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.concurrent.*;

public class ExecutorTests{


	@Test
	public void waitToComplete() throws InterruptedException {
		final ExecutorService executor = Executors.newCachedThreadPool(); 
		final CountDownLatch latch = new CountDownLatch(1); 
		executor.execute(new FiniteThreadNamePrinterLatch(latch)); 
		latch.await(5, TimeUnit.SECONDS);
	}



	private static class FiniteThreadNamePrinterLatch implements Runnable { 
		final CountDownLatch latch;

		private FiniteThreadNamePrinterLatch(final CountDownLatch latch) { 
			this.latch = latch;
		}

		@Override
		public void run() {
			for (int i = 0; i < 25; i++) { 
				System.out.println("Run from thread: " + Thread.currentThread().getName());
			}
		
			latch.countDown(); 
		}
	}


	private static class PiCalculator implements Callable<Double> {

		public Double call() throws Exception { 
			double currVal = 1.0;
			double nextVal = 0.0;
			double denominator = 1.0;

			for(int i = 0; Math.abs(nextVal - currVal) > 0.000000001d; denominator += 2.0, i++) {
				currVal = nextVal;
				if(i % 2 == 1) {
					nextVal = currVal - (1 / denominator); 
				} else {
					nextVal = currVal + (1 / denominator); 
				}
			}

			return currVal * 4; 
		}
	}


	static class ThreadPrinter implements Runnable { 

		@Override
		public void run() {

			for(int i = 0; i < 5; i++) {
				System.out.println("From the new thread: "+ Thread.currentThread().getName());

				try { Thread.sleep(1000);

				} catch (InterruptedException e) { 
					e.printStackTrace();
				} 
			}
		} 
	}


	@Test
	public void doesntFinish(){


		final Executor executor = Executors.newCachedThreadPool(); 
		executor.execute(new ThreadPrinter()); 
		executor.execute(new ThreadPrinter()); 
		executor.execute(new ThreadPrinter());

	}


	@Test
	public void piCalculator() throws InterruptedException, ExecutionException,TimeoutException {

		final ExecutorService executorService = Executors.newCachedThreadPool();

		final long startTime = System.currentTimeMillis(); 

		final Future<Double> future =executorService.submit(new PiCalculator()); 

		final double pi = future.get(10, TimeUnit.SECONDS);

		final long stopTime = System.currentTimeMillis(); 

		System.out.printf("\nCalculated Pi in %f seconds: %10.9f%n",(stopTime - startTime)/1000.0D, pi);

		executorService.shutdown(); 
	}	


}


