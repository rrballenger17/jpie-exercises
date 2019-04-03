import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.*;
import java.nio.file.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TimeoutTests{


	@Test
	public void manualResponseTimeCheck() throws InterruptedException {

		final CountDownLatch latch = new CountDownLatch(1); 
		
		final List<Integer> messages = new ArrayList<Integer>();

		final Runnable countRunnable = new Runnable() { 
			@Override
			public void run() {
				
				messages.add(1);				
				latch.countDown(); 
			}
		};

		new Thread(countRunnable).start(); 
		
		assertTrue(latch.await(5, TimeUnit.SECONDS));

		if(!messages.contains(1)) {
			fail("Runnable did not finish or increment the count");
		} 
	}

	@Test(timeout = 4000L)
	public void serviceResponseTime() throws InterruptedException{

		Thread.sleep(3000);

		assertNotNull(new ArrayList<Double>());
	}




}









