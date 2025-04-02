package C04;

public class UserDto {
	private String userid;
	private String password;
	private String role;
	//생성자/getterandsetter/toSTring
	
	public UserDto(){}
	public UserDto(String userid, String password, String role) {
		super();
		this.userid = userid;
		this.password = password;
		this.role = role;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
