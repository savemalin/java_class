package jdbc;

public class Book {
	
	private int bid;
	private String btitle;
	private String bauthor;
	private String bpublisher;
	private int bea;
	
	public Book() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", btitle=" + btitle + ", bauthor=" + bauthor + ", bpublisher=" + bpublisher
				+ ", bea=" + bea + "]";
	}



	public Book(int bid, String btitle, String bauthor, String bpublisher, int bea) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
		this.bea = bea;
	}
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
