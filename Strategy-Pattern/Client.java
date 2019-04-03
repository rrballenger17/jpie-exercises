import java.io.*;

public class Client {

	private final Logging logging;


	public Client(Logging logging) {
		this.logging = logging; 
	}

	public void doWork(final String message) { 
			logging.write(message); 
	}


	public static void main(String args[]){


		Client cons = new Client(new ConsoleLogging());
		cons.doWork("this should print to the console");


		Client file = new Client(new FileLogging(new File("output.txt")));
		file.doWork("this should print to the file");

		

	}



}


