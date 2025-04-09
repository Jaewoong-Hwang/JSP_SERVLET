package Utils;

public class Join1Dto {
	private String regist_month;
	private String c_no;
	private String c_name;
	private String class_name;
	private String class_area;
	private String tuition;
	private String grade;

	public Join1Dto () {}

	public Join1Dto(String regist_month, String c_no, String c_name, String class_name, String class_area,
			String tuition, String grade) {
		super();
		this.regist_month = regist_month;
		this.c_no = c_no;
		this.c_name = c_name;
		this.class_name = class_name;
		this.class_area = class_area;
		this.tuition = tuition;
		this.grade = grade;
	}

	public String getRegist_month() {
		return regist_month;
	}

	public void setRegist_month(String regist_month) {
		this.regist_month = regist_month;
	}

	public String getC_no() {
		return c_no;
	}

	public void setC_no(String c_no) {
		this.c_no = c_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getClass_area() {
		return class_area;
	}

	public void setClass_area(String class_area) {
		this.class_area = class_area;
	}

	public String getTuition() {
		return tuition;
	}

	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Join1Dto [regist_month=" + regist_month + ", c_no=" + c_no + ", c_name=" + c_name + ", class_name="
				+ class_name + ", class_area=" + class_area + ", tuition=" + tuition + ", grade=" + grade + "]";
	}
	
	

}
