

import java.util.*;

public class ReverseString{


	public static String reverse(String input){

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<input.length(); i++){

			sb.insert(0,input.charAt(i));

		}

		return sb.toString();

	}


	public static void main(String[] args){


		System.out.println(reverse("DOG"));
		System.out.println("\n");

		System.out.println(reverse("keep"));

	}

}





