package array;

import java.util.ArrayList;


public class DogTestArrayList {

	public static void main(String[] args) {
		
		ArrayList<Dog> d = new ArrayList<Dog>();
		
		d.add(new Dog("숑이","비숑"));
		d.add(new Dog("마요","비숑"));
		d.add(new Dog("보리","비숑"));
		d.add(new Dog("태식이","시바"));
		d.add(new Dog("뽀송이","말티즈"));
		
		for (Dog dog : d) {
			System.out.println(dog.showDogInfo());
		}
		
		

	}

}
