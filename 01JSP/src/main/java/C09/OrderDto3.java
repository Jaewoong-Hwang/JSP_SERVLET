package C09;

import java.time.LocalDate;


public class OrderDto3 {
	private String ADDR;
	private LocalDate ORDER_DATE;
	private Integer SUM;
	
	public OrderDto3()	{}

	public OrderDto3(String aDDR, LocalDate oRDER_DATE, Integer sUM) {
		super();
		ADDR = aDDR;
		ORDER_DATE = oRDER_DATE;
		SUM = sUM;
	}

	public String getADDR() {
		return ADDR;
	}

	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}

	public LocalDate getORDER_DATE() {
		return ORDER_DATE;
	}

	public void setORDER_DATE(LocalDate oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}

	public Integer getSUM() {
		return SUM;
	}

	public void setSUM(Integer sUM) {
		SUM = sUM;
	}

	@Override
	public String toString() {
		return "OrderDto3 [ADDR=" + ADDR + ", ORDER_DATE=" + ORDER_DATE + ", SUM=" + SUM + "]";
	}
	
	
}
