
import java.util.*;

public class FizzBuzzTests {

	public static String toWord(int divisor, int num, String replace){

		if(num % divisor == 0){
			return replace;
		}

		return "";


	}


	public static List<String> fizzBuzz(final int n){


		List<String> toReturn = new ArrayList<String>();

		for(int i=0; i<=n; i++){

			String output = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");

			if(output.length() == 0){
				toReturn.add("" + i);

			}else{
				toReturn.add(output);
			}

			
			

		}

		return toReturn;




	}


	public static void main(String[] args){

		List<String> arr = new ArrayList<String>();

		arr = fizzBuzz(30);

		for(String x: arr){
			System.out.println(x);
		}


	}




}










