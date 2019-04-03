
import java.util.*;


public class GenericStack<E> {


	private final List<E> values;


	public GenericStack() {
		values = new LinkedList<E>();
	}


	public void push(final E object) { 
		values.add(0, object);
	}

	public E pop() {

		if (values.size() == 0) {

			return null;
		}
		
		return values.remove(0); 

	}


	public static void main(String[] args){


		GenericStack<Double> gs = new GenericStack<Double>();

		gs.push(3.1415D);

		System.out.println("Should be pi: " + gs.pop());


	}


}