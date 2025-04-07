package Utils;

public class MemberDto {
	private String m_no;
	private String m_name;
	private String p_name;
	private String p_school;
	private String m_jumin;
	private String m_city;
	private String p_tel1;
	private String p_tel2;
	private String p_tel3;
	//나머지 추가코드 넣어주세요(생성자 / getter and setter / toString)
	public MemberDto() {}
	public MemberDto(String m_no, String m_name, String p_name, String p_school, String m_jumin, String m_city,
			String p_tel1, String p_tel2, String p_tel3) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.p_name = p_name;
		this.p_school = p_school;
		this.m_jumin = m_jumin;
		this.m_city = m_city;
		this.p_tel1 = p_tel1;
		this.p_tel2 = p_tel2;
		this.p_tel3 = p_tel3;
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_school() {
		return p_school;
	}
	public void setP_school(String p_school) {
		this.p_school = p_school;
	}
	public String getM_jumin() {
		return m_jumin;
	}
	public void setM_jumin(String m_jumin) {
		this.m_jumin = m_jumin;
	}
	public String getM_city() {
		return m_city;
	}
	public void setM_city(String m_city) {
		this.m_city = m_city;
	}
	public String getP_tel1() {
		return p_tel1;
	}
	public void setP_tel1(String p_tel1) {
		this.p_tel1 = p_tel1;
	}
	public String getP_tel2() {
		return p_tel2;
	}
	public void setP_tel2(String p_tel2) {
		this.p_tel2 = p_tel2;
	}
	public String getP_tel3() {
		return p_tel3;
	}
	public void setP_tel3(String p_tel3) {
		this.p_tel3 = p_tel3;
	}
	@Override
	public String toString() {
		return "MemberDto [m_no=" + m_no + ", m_name=" + m_name + ", p_name=" + p_name + ", p_school=" + p_school
				+ ", m_jumin=" + m_jumin + ", m_city=" + m_city + ", p_tel1=" + p_tel1 + ", p_tel2=" + p_tel2
				+ ", p_tel3=" + p_tel3 + "]";
	}
	
}
