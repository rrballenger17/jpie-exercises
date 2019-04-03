
import java.util.*;


public class QuickSortTests {


	public static List<Integer> quickSort(List<Integer> numbers) {

		if(numbers.size() <= 0 ){
			return new ArrayList<Integer>();
		}

		List<Integer> less = new ArrayList<Integer>();
		List<Integer> more = new ArrayList<Integer>();

		int pivot = numbers.get(0);

		for(int i=1; i<numbers.size(); i++){

			int num = numbers.get(i);

			if(num <= pivot){
				less.add(num);
			}else{
				more.add(num);
			}

		}

		less = quickSort(less);
		more = quickSort(more);

		less.add(pivot);
		less.addAll(more);

		return less;
		

	}




	public static void main(String args[]){

		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(7, 6, 5, 4, 4, 3, 1));

		System.out.println("ascending order: " + quickSort(arr).toString());

	}


}