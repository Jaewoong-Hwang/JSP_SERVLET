package Utils;

public class TeacherDto {
	private String TEACHER_CODE;
	private String TEACHER_NAME;
	private String CLASS_NAME;
	private Integer CLASS_PRICE;
	private String TEACHER_REGIST_DATE;

	public TeacherDto() {}

	public TeacherDto(String tEACHER_CODE, String tEACHER_NAME, String cLASS_NAME, Integer cLASS_PRICE,
			String tEACHER_REGIST_DATE) {
		super();
		TEACHER_CODE = tEACHER_CODE;
		TEACHER_NAME = tEACHER_NAME;
		CLASS_NAME = cLASS_NAME;
		CLASS_PRICE = cLASS_PRICE;
		TEACHER_REGIST_DATE = tEACHER_REGIST_DATE;
	}

	public String getTEACHER_CODE() {
		return TEACHER_CODE;
	}

	public void setTEACHER_CODE(String tEACHER_CODE) {
		TEACHER_CODE = tEACHER_CODE;
	}

	public String getTEACHER_NAME() {
		return TEACHER_NAME;
	}

	public void setTEACHER_NAME(String tEACHER_NAME) {
		TEACHER_NAME = tEACHER_NAME;
	}

	public String getCLASS_NAME() {
		return CLASS_NAME;
	}

	public void setCLASS_NAME(String cLASS_NAME) {
		CLASS_NAME = cLASS_NAME;
	}

	public Integer getCLASS_PRICE() {
		return CLASS_PRICE;
	}

	public void setCLASS_PRICE(Integer cLASS_PRICE) {
		CLASS_PRICE = cLASS_PRICE;
	}

	public String getTEACHER_REGIST_DATE() {
		return TEACHER_REGIST_DATE;
	}

	public void setTEACHER_REGIST_DATE(String tEACHER_REGIST_DATE) {
		TEACHER_REGIST_DATE = tEACHER_REGIST_DATE;
	}

	@Override
	public String toString() {
		return "TeacherDto [TEACHER_CODE=" + TEACHER_CODE + ", TEACHER_NAME=" + TEACHER_NAME + ", CLASS_NAME="
				+ CLASS_NAME + ", CLASS_PRICE=" + CLASS_PRICE + ", TEACHER_REGIST_DATE=" + TEACHER_REGIST_DATE + "]";
	}

	
	
}
