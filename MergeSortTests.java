
import java.util.*;


public class MergeSortTests {



	public static List<Integer> merge(List<Integer> left, List<Integer> right){

		List<Integer> merged = new ArrayList<Integer>();

		while(true){


			if(left.size() == 0){
				merged.addAll(right);
				break;
			}

			if(right.size() == 0){
				merged.addAll(left);
				break;
			}

			int leftValue = left.get(0);
			int rightValue = right.get(0);

			if( leftValue < rightValue ){
				merged.add(leftValue);

				left.remove(0);
			}else{
				merged.add(rightValue);

				right.remove(0);
			}


		}

		return merged;

	}


	public static List<Integer> mergeSort(List<Integer> numbers) {


		if(numbers.size() <= 1){
			return numbers;
		}


		List<Integer> left = new ArrayList<Integer>( numbers.subList(0, numbers.size()/ 2));

		List<Integer> right = new ArrayList<Integer>(numbers.subList(numbers.size()/ 2, numbers.size()));
		
		left = mergeSort(left);

		right = mergeSort(right);

		List<Integer> merged = merge(left, right);


		return merged;


	}




	public static void main(String args[]){

		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(7, 6, 5, 4, 4, 3, 1));

		System.out.println("ascending order: " + mergeSort(arr).toString());

	}


}