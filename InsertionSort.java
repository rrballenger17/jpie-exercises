
import java.util.*;


public class InsertionSort {


	public static List<Integer> insertionSort(int[] numbers) {

		
		List<Integer> list = new LinkedList<Integer>();

		for(int i=0; i< numbers.length; i++){


			boolean inserted = false;
			for(int j=0; j<list.size(); j++){


				if(numbers[i] < list.get(j)){
					list.add(j, numbers[i]);
					inserted = true;
					break;
				}


			}

			if(inserted == false){
				list.add(numbers[i]);
			}


		}

		return list;


	}




	public static void main(String args[]){

		int[] arr = {7, 6, 5, 4, 4, 3, 1};

		

		System.out.println("ascending order: " + insertionSort(arr).toString());

	}


}



