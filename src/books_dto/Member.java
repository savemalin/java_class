package books_dto;

import java.util.ArrayList;

public class Member {

	private String mid; // 아이디
	private String mpw; // 비밀번호
	private String mname; // 이름
	private String memail; // 이메일
	private String mphone; // 전화번호
	private String mdate; // 가입일
	
	

	private ArrayList<Brent> brentList;

	public Member() {
		this.brentList = new ArrayList<>();

	}

	public ArrayList<Brent> getBrentList() {
		return brentList;
	}

	public void setBrentList(ArrayList<Brent> brentList) {
		this.brentList = brentList;
	}

	public Member(String mid, String mpw, String mname, String memail, String mphone) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.memail = memail;
		this.mphone = mphone;
		
	}

	// getter, setter
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

}
