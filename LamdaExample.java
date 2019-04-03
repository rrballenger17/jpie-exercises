
import java.util.*;

public class LamdaExample{



	public static void main(String args[]){


		List<Integer> ints = new ArrayList<>(); 
		ints.add(1);
		ints.add(2);
		ints.add(3);

		List<Integer> newInts = new ArrayList<>(); 

		ints.forEach(i -> { newInts.add(i+10); });

		for(int i = 0; i < ints.size(); i++) {
			System.out.println(newInts.get(i));
		}


		assert ints.size() == newInts.size();


		System.out.println("Validated"); 


	}



}