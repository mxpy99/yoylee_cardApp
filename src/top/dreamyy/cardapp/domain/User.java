package top.dreamyy.cardapp.domain;

public class User {
	private String name;
	private String password;
	private String mibao;
	
	//无参构造函数
	public User() {
		super();
	}
	//有参构造函数
	public User(String name, String password, String mibao) {
		super();
		this.name = name;
		this.password = password;
		this.mibao = mibao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMibao() {
		return mibao;
	}
	public void setMibao(String mibao) {
		this.mibao = mibao;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", mibao=" + mibao + "]";
	}
	
	
}
