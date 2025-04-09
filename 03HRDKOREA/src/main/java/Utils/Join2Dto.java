package Utils;

public class Join2Dto {
	private String teacher_code;
	private String class_name;
	private String teacher_name;
	private int total_tuition;
	
	public Join2Dto() {}

	public Join2Dto(String teacher_code, String class_name, String teacher_name, int total_tuition) {
		super();
		this.teacher_code = teacher_code;
		this.class_name = class_name;
		this.teacher_name = teacher_name;
		this.total_tuition = total_tuition;
	}

	public String getTeacher_code() {
		return teacher_code;
	}

	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public int getTotal_tuition() {
		return total_tuition;
	}

	public void setTotal_tuition(int total_tuition) {
		this.total_tuition = total_tuition;
	}

	@Override
	public String toString() {
		return "Join2Dto [teacher_code=" + teacher_code + ", class_name=" + class_name + ", teacher_name="
				+ teacher_name + ", total_tuition=" + total_tuition + "]";
	}
	
	
	
	
	
}
