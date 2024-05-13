package day15;

public class Animal_Main {

	public static void main(String[] args) {
		Animal animal = new Animal();
//		animal.Name = "동물이름";
		animal.setName("동물이름");
//		System.out.println("animal.name : " + animal.name);
		System.out.println("animal.setName : "+animal.getName());
		
		Cat cat = new Cat();
		cat.setName ("나비");
		
		System.out.println("cat.getName : "+cat.getName());
		//cat 객체에 "야옹" sound 저장
		cat.setSound("야옹");
		cat.sound();
		cat.eat();
		
		Dog dog = new Dog();
		dog.setName("뽀삐");
		System.out.println("dog.getName : "+dog.getName());
		dog.setSound("멍멍");
		dog.sound();
		dog.eat();
		
		
	}

}
