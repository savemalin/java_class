package books_dto;

import java.util.ArrayList;

public class Book {

	private int bid; // 도서아이디
	private String btitle; // 제목
	private String bauthor; // 저자
	private String bpublisher; // 출판사
	private int bea; // 재고

	private ArrayList<Brent> brentList = new ArrayList<>();

	public Book() {

	}

	public ArrayList<Brent> getBrentList() {
		return brentList;
	}

	public void setBrentList(ArrayList<Brent> brentList) {
		this.brentList = brentList;
	}

	public Book(int bid, String btitle, String bauthor, String bpublisher, int bea) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
		this.bea = bea;
	}
	public Book(String btitle, String bauthor, String bpublisher, int bea) {
		super();
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
		this.bea = bea;
	}

	// getter, setter
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}

	public int getBea() {
		return bea;
	}

	public void setBea(int bea) {
		this.bea = bea;
	}

}
