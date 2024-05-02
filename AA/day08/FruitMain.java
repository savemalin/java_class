package day08;

public class FruitMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit apple = new Fruit();
		apple.name = "사과";
		apple.color = "빨강";
		apple.isSeed = true;
		apple.Print();
		
		// banana 2번째 생성자로 객체생성
		Fruit banana = new Fruit("바나나");
		banana.color ="노란";
		banana.isSeed=true;
		banana.Print();
		
		// melon 3번째 생성자로 객체생성
		Fruit melon = new Fruit("메론","초록");
		melon.isSeed=true;
		melon.Print();
		
		// cherry 4번째 생성자로 객체생성
		Fruit cherry = new Fruit("체리","빨강",true);
		cherry.Print();
		
		
		
		
		
		

	}

}
