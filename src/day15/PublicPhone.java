package day15;

public class PublicPhone extends Phone{
	//기본전화+공공전화 특성
	private String place;//공중전화 설치 장소
	private String phoneNumber;

	public PublicPhone() {
		super();
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public void PhNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public PublicPhone(String place) {
		this.place = place;
	}
	
	public PublicPhone(String place, String phoneNumber) {
		this.place=place;
		this.phoneNumber=phoneNumber;
	}
	
	
	
	
}
