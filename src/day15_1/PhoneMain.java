package day15_1;

import day15.Phone;

public class PhoneMain {
	//extends가 없는경우에 다른패키지의 클래스가 있는 경우 상속받은게 아니기에 public를 제외하고 사용불가능

	public static void main(String[] args) {
		
		Phone phone = new Phone();
//		phone.privateValue = "private";
//		phone.defaultValue="default";
//		phone.protectedValue="protected";
		phone.publicValue="public";
		
		SmartPhone smartPhone = new SmartPhone();
//		smartPhone.privateValue = "privateValue";
//		smartPhone.defaultValue = "defaultValue";
//		smartPhone.protectedValue = "protectedValue";
		smartPhone.publicValue = "publicValue";
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
