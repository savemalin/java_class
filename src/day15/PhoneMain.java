package day15;

public class PhoneMain {

	public static void main(String[] args) {
		//
		// PublicPhone 객체 생성
		// place를 "인천일보아카데미"로 초기화
		// place 필드값을 출력
//	PublicPhone publicPhone = new PublicPhone();
//	publicPhone.setPlace("인천일보아카데미");
//	System.out.println("publicPhone.getPlace : "+publicPhone.getPlace());

		PublicPhone publicPhone = new PublicPhone();
		publicPhone.setPhoneNumber("032-876-3332");
		publicPhone.setPlace("인천일보아카데미");
		System.out.println("publicPhone2.place : " + publicPhone.getPlace());
		System.out.println("phNumber.phoneNumber : " + publicPhone.getPhoneNumber());
		System.out.println();

		PublicPhone publicPhone4 = new PublicPhone("인천일보아카데미");

		PublicPhone publicPhone5 = new PublicPhone("인천일보아카데미", "032-876-3332");
		System.out.println(publicPhone5.getPlace());
		System.out.println(publicPhone5.getPhoneNumber());

		//Phone Class : package day15;
		//PhoneMain Class : package day15;
		
		Phone phone = new Phone();
//		phone.privateValue = "12"; // private은 접근불가
		phone.defaultValue="default";
		phone.protectedValue="protected";
		phone.publicValue="public";
		
		SmartPhone smartPhone = new SmartPhone();
//		phone.privateValue = "private"; 
		smartPhone.defaultValue="default";
		smartPhone.protectedValue="protected";
		smartPhone.publicValue="public";
		smartPhone.valueInfo();
		
		
		
	}

}
