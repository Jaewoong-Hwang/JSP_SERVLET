package Utils;

public class MemberDto {
	private String c_number;
	private String c_name;
	private String phone;
	private String address;
	private String grade;
	
	public MemberDto() {}

	public MemberDto(String c_number, String c_name, String phone, String address, String grade) {
		super();
		this.c_number = c_number;
		this.c_name = c_name;
		this.phone = phone;
		this.address = address;
		this.grade = grade;
	}

	public String getC_number() {
		return c_number;
	}

	public void setC_number(String c_number) {
		this.c_number = c_number;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "MemberDto [c_number=" + c_number + ", c_name=" + c_name + ", phone=" + phone + ", address=" + address
				+ ", grade=" + grade + "]";
	}

	
	
}
