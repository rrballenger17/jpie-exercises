
import java.util.*;


public class MapTests {



	public static void linkedTest(){

		Map<Integer, Integer> list = new LinkedHashMap<Integer, Integer>();

		list.put(1, 5);
		list.put(-5, 10);
		list.put(7, 11);
		list.put(-2, 12);

		System.out.println("LinkedHashMap keys 1 -5 7 -2");

		for(int x: list.keySet()){

			System.out.println(x);
		}

	}


	public static void treeMapTest() {

		Map<Integer, Integer> list = new TreeMap<Integer, Integer>();

		list.put(1, 5);
		list.put(-5, 10);
		list.put(7, 11);
		list.put(-2, 12);

		System.out.println("LinkedHashMap keys -5 -2 1 7");

		for(int x: list.keySet()){

			System.out.println(x);
		}

	}




	public static void main(String args[]){

		linkedTest();

		treeMapTest();

	}


}