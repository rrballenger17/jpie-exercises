
import java.util.*;


public class BubbleSort {


	public static void bubbleSort(int[] numbers) {

		boolean changed = true;

		while(changed){


			changed = false;

			for(int i=0; i<=numbers.length - 2; i++){

				if(numbers[i] > numbers[i + 1]){
				
					int temp = numbers[i + 1];

					numbers[i + 1] = numbers[i];

					numbers[i] = temp;

					changed = true;

				}

			}

		}

	}




	public static void main(String args[]){

		int[] arr = {7, 6, 5, 4, 4, 3, 1};

		bubbleSort(arr);

		System.out.println("ascending order: " + Arrays.toString(arr) );

	}


}