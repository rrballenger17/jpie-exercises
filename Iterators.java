
import java.util.*;


public class Iterators<T> {



	 static class ListIterator<T> implements Iterator<T> {
		private final Iterator<Iterator<T>> listIterator; 
		private Iterator<T> currentIterator;


		public ListIterator(List<Iterator<T>> iterators) { 
			this.listIterator = iterators.iterator(); 
			this.currentIterator = listIterator.next();
		}


		@Override
		public boolean hasNext() {
			if(!currentIterator.hasNext()) { 
				if (!listIterator.hasNext()) {
					return false; 
				}

				currentIterator = listIterator.next();

				hasNext(); 
			}

			return true; 
		}

		@Override
		public T next(){

			if(currentIterator.hasNext()){
				return currentIterator.next();
			}

			if(!listIterator.hasNext()){
				return null;
			}

			currentIterator = listIterator.next();


			return next();
		}

		@Override
		public void remove(){
			
		}

	}




	public static void main(String args[]){



		final Iterator<Integer> a = Arrays.asList(1, 2, 3, 4, 5).iterator(); 
		final Iterator<Integer> b = Arrays.asList(6).iterator();
		final Iterator<Integer> c = new ArrayList<Integer>().iterator(); 
		final Iterator<Integer> d = new ArrayList<Integer>().iterator(); 
		final Iterator<Integer> e = Arrays.asList(7, 8, 9).iterator();

		final Iterator<Integer> singleIterator = new ListIterator(Arrays.asList(a, b, c, d, e));


		System.out.println("Should print 1 to 9: ");

		for (Integer i = 1; i <= 9; i++) {

			if(singleIterator.hasNext()){
				System.out.println(singleIterator.next());
			}

		}


		
	}


}