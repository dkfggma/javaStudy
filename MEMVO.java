package db04;
//VO  : vlaue object
//DTO : data transfer object
public class MEMVO {
	//fields
	private int    memid;
	private String memname;
	private String email;
	private String in_date;
	
	//constructor
	public MEMVO(int memid, String memname, String email, String in_date) {
		
		this.memid = memid;
		this.memname = memname;
		this.email = email;
		this.in_date = in_date;
	}

	//getter / setter
	public int getMemid() {
		return memid;
	}

	public void setMemid(int memid) {
		this.memid = memid;
	}

	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIn_date() {
		return in_date;
	}

	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}

	//toString
	@Override
	public String toString() {
		return "MEMVO [memid=" + memid + ", memname=" + memname + ", email=" + email + ", in_date=" + in_date + "]";
	}
	
	

}
