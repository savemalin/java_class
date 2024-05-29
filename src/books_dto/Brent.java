package books_dto;

public class Brent {

	private int rid; // 대여내역아이디

	private String mid; // 회원아이디

	private int bid; // 도서아이디

	private String rentdate; // 대여일

	private String returndate; // 반납일

//	private ArrayList<Member> memberList; - mid : 멤버아이디 대신 어레이리스트로 여러개 나와 비교할수 있다(중복확인)

	private Member member; // 회원정보

	private Book book; // 도서정보

	public Brent() {
		this.member=new Member();
		this.book=new Book();

	}

	public Brent(int rid, String mid, int bid, String rentdate, String returndate) {
		super();
		this.rid = rid;
		this.mid = mid;
		this.bid = bid;
		this.rentdate = rentdate;
		this.returndate = returndate;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getRentdate() {
		return rentdate;
	}

	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
	
}
