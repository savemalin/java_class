package day14;

public class Member {
	private String id; // 아이디
	private String pw; // 비밀번호
	private String name; // 이름
	private String email;// 이메일
	
	private Book[] rentalList; // 대여중인 도서 목록

	public Member(String id, String pw, String name, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		
		this.rentalList = new Book[3];
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Book[] getRentalList() {
		return rentalList;
	}

	public void setRentalList(Book[] rentalList) {
		this.rentalList = rentalList;
	}
	
	// 회원의 도서 대여 정보 출력 기능
	public void rentalInfo() {
		System.out.println("대여중인 도서 목록");
		int rentalCount=0;
		for(int i=0;i<rentalList.length;i++) {
			if(rentalList[i]!=null) {
				rentalCount++;
			System.out.println("책이름 : "+rentalList[i].getTitle());
			}			
		}		
		if(rentalCount>0) {
			System.out.println("총"+rentalCount+ "권의 도서를 대여중 입니다");
		}else {
			System.out.println("대여 중인 도서가 없습니다.");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
