package day15;

public class Phone {
	//기본적인 전화
	private String phoneNumber;//전화번호
	
	
	
	public void sendCall() {
		System.out.println("전화걸기");
	}
	
	
	//Phone Class - day15
	public void receiveCall() {
		System.out.println("전화받기");
	}
	String defaultValue;
	protected String protectedValue;//외부패키지면 안되지만 상속받으면 가능
	public String publicValue;
	private String privateValue;
	//크기순서 private < default < protected < public
	//private => 같은 패키지에서만 사용가능
	//default => 같은 패키지에서만 사용가능
	//protected => 같은 패키지에서만 사용가능
	//- 단, 상속을 받은 클래스는 다른 패키지에서 사용가능
	//public : 모든 패키지에서 사용가능
	
}
