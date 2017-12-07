package top.dreamyy.cardapp.domain;

public class Card {
	private String name;
	private String gender;
	private String phone;
	private String company;
	private String address;
	private String email;
	//后面代码将其转换为二进制
	private String createdate;
	
	
	
	public Card( String name, String gender, String phone, String company, String address, String email,
			 String createdate) {
		super();
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.company = company;
		this.address = address;
		this.email = email;
		this.createdate = createdate;
	}
	public Card() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "Card ["+" name=" + name + ", gender=" + gender + ", phone=" + phone + ", company=" + company
				+ ", address=" + address + ", email=" + email  + ", createdate=" + createdate + "]";
	}
	
	
}
