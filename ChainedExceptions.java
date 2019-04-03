

public class ChainedExceptions {


	private static int addNumbers(int first, int second) { 
		
		if(first > 42) {
			throw new IllegalArgumentException("First parameter must be small"); 
		}
		return first + second; 
	}

	public static void main(String args[]){

		int total = 0;

		try {
			total = addNumbers(100, 25); 
			System.out.println("total = " + total);
		} catch (IllegalArgumentException e) {

			throw new IllegalStateException("Unable to add numbers together", e);
		} 

	}
}

