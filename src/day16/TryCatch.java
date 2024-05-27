package day16;

public class TryCatch {

	public static void main(String[] args) {
		// try - catch : 예외처리
		//try{
		//		실행할 코드
		//} catch(예외처리클래스 객체){
		//	try에서 예외가 발생할 경우 실행되는 부분
		//}
		try {
			System.out.println("try - 시작");
		int[] numbers = new int[3]; // numbers 배열의 인덱스 :[0],[1],[2] 크기가 3인 배열
		numbers[2]=100;//numbers 배열의 [5]인텍스 100을 저장
		
		int num = 10/0;//숫자 / 0(예외발생)
		System.out.println("num : "+num);
		
		System.out.println("try - 끝");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("숫자는 0으로 나눌 수 없습니다.");
		}
		System.out.println("실행확인");
		
		
		
	}

}
