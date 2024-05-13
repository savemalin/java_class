package day15;

public class SmartPhone extends Phone {
	// 기본전화+스마트폰 특성(인터넷+추가기능 등)

//	public void receiveCall(String phNuber) {
//
//		System.out.println("걸려온 번호 확인");
//
//		System.out.println("전화 받기");
//
//	}

	@Override
	public void receiveCall() {
		System.out.println("걸려온 번호 확인");

		System.out.println("전화 받기");
		
	}

	public void valueInfo() {
//		System.out.println("privateValue : "+privateValue);
		System.out.println("defaultValue : "+defaultValue);
		System.out.println("ProtectedValue : "+protectedValue);
		System.out.println("publicValue : "+publicValue);
		
		
	}
}
