package Utils;

public class SubVoteDto {
	 private String m_no;
	 private String m_name;
	 private Integer count;
	 
	 
	 public SubVoteDto() {}


	public SubVoteDto(String m_no, String m_name, Integer count) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.count = count;
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


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "SubVoteDto [m_no=" + m_no + ", m_name=" + m_name + ", count=" + count + "]";
	}

	 

}
