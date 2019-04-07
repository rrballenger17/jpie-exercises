
import java.util.*;
import java.lang.ref.WeakReference;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.concurrent.*;
import java.io.*;


public class WriteToFileTest{



	static class Pair implements Serializable { 
		private final int number;
		private final String name;

		public Pair(int number, String name) { 
			this.number = number;
			this.name = name;
		}

		public int getNumber() { 
			return number;
		}

		public String getName() { 
			return name;
		} 
	}



	@Test
	public void writeData() throws IOException {

		final FileOutputStream fos = new FileOutputStream("tempFile"); 
		final ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeInt(101); 
		oos.writeBoolean(false); 
		oos.writeUTF("Writing a string");

		final Pair pair = new Pair(42, "Forty two"); 
		oos.writeObject(pair);
		
		oos.flush(); 
		oos.close(); 
		fos.close();
	}


	@Test
	public void readData() throws IOException, ClassNotFoundException {
		final FileInputStream fis = new FileInputStream("tempFile"); 
		final ObjectInputStream ois = new ObjectInputStream(fis);
		final int number = ois.readInt();
		final boolean bool = ois.readBoolean(); 
		final String string = ois.readUTF();

		final Pair pair = (Pair) ois.readObject();

		assertEquals(101, number); 
		assertFalse(bool);
		assertEquals("Writing a string", string); 
		assertEquals(42, pair.getNumber()); 
		assertEquals("Forty two", pair.getName());


	}


}





