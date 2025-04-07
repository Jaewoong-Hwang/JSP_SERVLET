package C09;

import java.time.LocalDate;

public class OrderDto2 {
	private LocalDate order_date;
	private Double	average;
	
	public OrderDto2() {}
	public OrderDto2(LocalDate order_date, Double average) {
		super();
		this.order_date = order_date;
		this.average = average;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	@Override
	public String toString() {
		return "OrderDto2 [order_date=" + order_date + ", average=" + average + "]";
	}
	
}	
