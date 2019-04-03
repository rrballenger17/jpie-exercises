

import java.util.*;



public class MapTest{


	static 	interface GenericOperation<A, B> { 
			B performOperation(A value);
		}



	static 	class StringLengthOperation implements GenericOperation<String, Integer> {
			@Override
			public Integer performOperation(String value) {
				return value.length(); 
			}
		}

	public static <A, B> List<B> mapList(final List<A> values,final GenericOperation<A, B> op) {

		final ArrayList<B> toReturn = new ArrayList<>(values.size()); 

		for (final A a : values) {
			toReturn.add(op.performOperation(a)); 

		}
			return toReturn; 

	}



	public static void main(String args[]){

		final List<String> strings = Arrays.asList( "acing", "the", "java", "interview");

		final List<Integer> expected = Arrays.asList(5, 3, 4, 9); 
	
		final List<Integer> actual = mapList(strings, new StringLengthOperation()); 

		System.out.println("Should be: " + expected.toString());

		System.out.println(actual.toString());



	}



}





