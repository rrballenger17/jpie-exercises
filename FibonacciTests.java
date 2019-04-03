


import java.util.*;
import java.io.*;

public class FibonacciTests{

	private static Map<Integer, Integer> cache = new HashMap<>();

	public static int cachedFibN(int n){


		//if( n< 0){
		//	throw new Exception("n must not be less than zero");
		//}

		cache.put(0, 0);
		cache.put(1, 1);

		return recursiveCachedFibN(n);

	}

	private static int recursiveCachedFibN(int n){

		if(cache.containsKey(n)){
			return cache.get(n);
		}

		int value = recursiveCachedFibN(n-1) + recursiveCachedFibN(n - 2);

		cache.put(n, value);

		return value;


	}



	public static int fibN(int n) { 

		//if (n < 0) {
		//	throw new IllegalArgumentException("n must not be less than zero");
		//}


		if (n == 1) return 1;
		if (n == 0) return 0;
		return (fibN(n - 1) + fibN(n - 2));
	}



	public static void main(String[] args){

		for(int i=5; i<=10; i++){

			System.out.println( cachedFibN(i) );


		}


		final long nonCachedStart = System.nanoTime(); 

		assert 1134903170 == fibN(45) : "Error with fib";

		final long nonCachedFinish = System.nanoTime(); 

		assert 1134903170 == cachedFibN(45) : "Error with cached fib";

		final long cachedFinish = System.nanoTime();


		System.out.printf("Non cached time: %d nanoseconds%n", nonCachedFinish - nonCachedStart);
		System.out.printf("Cached time: %d nanoseconds%n", cachedFinish - nonCachedFinish);


	}





}










