public class Car extends Vehicle {

	@Override
	public String getName() { 
		return "CAR";
	} 

	public static void main(String args[]){

		Vehicle car = new Car();

		System.out.println(car.getName());

	}


}
