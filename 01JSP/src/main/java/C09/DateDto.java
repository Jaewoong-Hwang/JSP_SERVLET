package C09;

public class DateDto {
	private  String ORDER_DATE;
	private Double AVG;
	
	public DateDto() {}

	public DateDto(String oRDER_DATE, Double aVG) {
		super();
		ORDER_DATE = oRDER_DATE;
		AVG = aVG;
	}

	public String getORDER_DATE() {
		return ORDER_DATE;
	}

	public void setORDER_DATE(String oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}

	public Double getAVG() {
		return AVG;
	}

	public void setAVG(Double aVG) {
		AVG = aVG;
	}

	@Override
	public String toString() {
		return "DateDto [ORDER_DATE=" + ORDER_DATE + ", AVG=" + AVG + "]";
	}
	
	

}
