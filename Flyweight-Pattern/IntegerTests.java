// The Flyweight Pattern can be a useful pattern in situations where you have several objects, and 
// many may represent the same value. In these instances, it can be possible to share the values as 
// long as the objects are immutable. 

import java.util.*;


public class IntegerTests {


	private static Integer[] cache = null;

	private static int low = -227;
	private static int high = 227;


	private static void initializeCache(){

		cache = new Integer[high - low + 1];

		for(int i=low; i<=high; i++){

			cache[i - low] = new Integer(i);

		}



	}


	public static Integer valueOf(int i) {

		if(cache == null){
			initializeCache();
		}

		if (i >= low && i <= high){
			return cache[i - low]; 
		}


		return new Integer(i);
  }



	public static void main(String args[]){
		if( IntegerTests.valueOf(-227) == IntegerTests.valueOf(-227)){
			System.out.println("pass");
		}

		if(IntegerTests.valueOf(-228) != IntegerTests.valueOf(-228)){
			System.out.println("pass 2");
		}

	}



}








