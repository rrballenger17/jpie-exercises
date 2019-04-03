
// A singleton is a class that allows only one instance to be created. It is often used to 
// create a single point of entry to a third party, such as a database or web service, so 
// that the number of connections can be easily managed and configured in one place.

public class SingletonTests{

	private static SingletonTests INSTANCE = null;

	public static synchronized SingletonTests getInstance() { 
		if (INSTANCE == null) {
			INSTANCE = new SingletonTests(); 
		}

		return INSTANCE; 
	}


	public SingletonTests(){
		database = "The Database Connection 1.7: " + System.currentTimeMillis();
	}



	private String database = null;

	public String getDBConnection(){
		return database;
	}


	public static void main(String args[]){


		SingletonTests st = SingletonTests.getInstance();

		System.out.println(st.getDBConnection());


		SingletonTests st2 = SingletonTests.getInstance();

		System.out.println(st2.getDBConnection());



	}



}




