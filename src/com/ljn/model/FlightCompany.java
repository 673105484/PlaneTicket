package com.ljn.model;

public class FlightCompany {
	private Integer flightCompanyId;
	private String cname;
	private String caddress;
	private String phone;
	private String cmail;
	private Integer fcstate;
	public FlightCompany() {
		
	}
	public FlightCompany(String cname,String caddress,String phone,String cmail,Integer fcstate) {
		this.cname=cname;
		this.caddress=caddress;
		this.phone=phone;
		this.cmail=cmail;
		this.fcstate=fcstate;
	}
	@Override
	public String toString() {
		return "FlightCompany [flightCompanyId=" + flightCompanyId + ", cname=" + cname + ", caddress=" + caddress
				+ ", phone=" + phone + ", cmail=" + cmail + ", fcstate=" + fcstate + "]";
	}
	public void setFlightCompanyId(Integer flightCompanyId) {
		this.flightCompanyId=flightCompanyId;
	}
	public Integer getFlightCompanyId() {
		return flightCompanyId;
	}
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCmail() {
		return cmail;
	}

	public void setCmail(String cmail) {
		this.cmail = cmail;
	}

	public Integer getFcstate() {
		return fcstate;
	}

	public void setFcstate(Integer fcstate) {
		this.fcstate = fcstate;
	}
}
