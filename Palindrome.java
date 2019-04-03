
import java.util.*;


public class Palindrome {



	public static boolean palindrome(String input){

		int spot = 0;

		int length = input.length();

		while(spot < length ){

			if(input.charAt(spot) != input.charAt(length - 1 - spot)){

				return false;


			}

			spot++;

		}

		return true;



	}


	public static void palindromeTest(String input, boolean result){


		boolean res = palindrome(input);

		if(res == result){
			System.out.println("passed");
		}else{
			System.out.println("failed");
		}





	}



	public static void main(String args[]){

		palindromeTest("racecar", true);
		palindromeTest("nike", false);

		
	}


}