package C09;

import java.time.LocalDate;

public class OrderDto {

	private String CATEGORY;
	private Integer SUM;
	
	public OrderDto() {}

	public OrderDto(String cATEGORY, Integer sUM) {
		super();
		CATEGORY = cATEGORY;
		SUM = sUM;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public Integer getSUM() {
		return SUM;
	}

	public void setSUM(Integer sUM) {
		SUM = sUM;
	}

	@Override
	public String toString() {
		return "OrderDto [CATEGORY=" + CATEGORY + ", SUM=" + SUM + "]";
	}
	
	
	
}
