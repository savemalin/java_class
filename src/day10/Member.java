package day10;

public class Member {
	String id;
	String pw;
	String name;
	String email;

	public Member(String id, String pw, String name, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}

	public void printMemberInfo() {
		System.out.println("[id] : " + id + " [pw] : " + pw + " [name] : " + name + " [email] :" + email);
	}

	// member의 자료가 저장된 list에 name과 id가 같을때 브레이크 아닐때 생성

}
