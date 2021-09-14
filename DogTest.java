package array;

public class DogTest {

	public static void main(String[] args) {

		Dog[] d = new Dog[5];
		
		for (int i = 0; i < d.length; i++) {
			d[i] = new Dog();
		}

		d[0].setName("숑이");
		d[0].setType("비숑");
		d[1].setName("태식이");
		d[1].setType("시바");
		d[2].setName("뽀송이");
		d[2].setType("말티즈");
		d[3].setName("보리");
		d[3].setType("비숑");
		d[4].setName("마요");
		d[4].setType("비숑");


		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i].showDogInfo());
		}

		for (Dog dog : d) {
			System.out.println(dog.showDogInfo());
		}

	}

}
