



public class FactorialTests {


	public static long factorial(int n){

		// exception for <= 0 

		int output = n;

		for(int i=n-1; i>0;i--){
			output *= i;
		}

		return output;

	}

	public static void main(String[] args){
		System.out.println("Factorial 5 is ... " + factorial(5));
	}


}




