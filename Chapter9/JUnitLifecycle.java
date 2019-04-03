import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;


public class JUnitLifecycle {
	
	private static int counter = 0;

	@BeforeClass
	public static void suiteSetup(){

		// 0 
		assertEquals(0, counter);
		counter++; 
	}

	public JUnitLifecycle() { 

		// 1
		// 5
		assertTrue(Arrays.asList(1, 5).contains(counter));
		counter++;
	}

	@Before
	public void prepareTest() {

		// 2
		// 6
		assertTrue(Arrays.asList(2,6).contains(counter));
		counter++; 
	}


	@Test
	public void peformFirstTest() {

		//3
		assertTrue(Arrays.asList(3,7).contains(counter));
		counter++; 
	}

	@Test
	public void performSecondTest(){

		//7
		assertTrue(Arrays.asList(3,7).contains(counter));
		counter++; 
	}

	@After
	public void cleanupTest() {

		//4 
		//8
		assertTrue(Arrays.asList(4,8).contains(counter));
		counter++; 
	}

}

