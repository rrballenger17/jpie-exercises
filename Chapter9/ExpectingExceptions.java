import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.*;
import java.nio.file.*;


public class ExpectingExceptions{


	@Test(expected = NoSuchFileException.class)
	public void expectException() throws IOException {
		Files.size(Paths.get("/tmp/non-existent-file.txt")); 
	}



	@Test
	public void testExceptionThrowingMethod() {
		
		try {
			Files.size(Paths.get("/tmp/non-existent-file.txt")); 
			fail("Should throw no such file exception"); 
		} catch (IOException e) {
			// test passed }
		}

	}


}