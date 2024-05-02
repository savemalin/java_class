package day05;

public class 배열 {

	public static void main(String[] args) {
//		String[] name = {"홍길동","이순신","장동건"};
//		name[2] = "김동건";
//		
//		
//		
//		System.out.println(name[0]);
//		System.out.println(name[1]);
//		System.out.println(name[2]);
//		
//		for(int i=0; i<100; i++) {
//			System.out.println(name[i]);
//		}
//		
		//name[] - []은 index로 방을 뜻하며 0번방부터 i번방까지
		// 배열은 for문과 짝꿍
		
		String[] name = {"홍길동","이순신","장동건"}; //값을 지정하기에 {}중괄호
		name[2] = "김동건";

		for(int i=0; i<3; i++) {
			System.out.println(name[i]);
		}
		int[] age = new int[10]; // age라는 변수에 0~9까지 10개의 빈방을 생성
		age[0]=88;
		age[1]=90;
		for(int i=0; i<name.length; i++) {//name이라는 배열의 길이
			System.out.println(age[i]);
		}// 기본값 int=0, double=0.00000, boolean=false... 나머지는 null(Ex:String=null)
		//어레인?이 아닌 배열은 한번 지정한 방의 갯수는 바꿀수없지만 방의 내용은 빼거나 바꿀수있다
		

	}

}
