package com.ljn.model;

import java.util.Date;

public class Flight {
	private String flightId;
	private Integer companyId;
	private String fstart;
	private String fend;
	private Integer jpiao;
	private Integer hpiao;
	private Date starttime;
	private Date endtime;
	private Integer jprice  ;
	private Integer  hprice  ;
	private Integer fstate;
    public Flight() {

	}
    public Flight (String flightId,Integer companyId,String fstart, String fend, Integer jpiao,Integer hpiao, Date starttime, Date endtime ,Integer jprice,
    		Integer hprice ,Integer fstate) {
    	this.flightId=flightId;
    	this.companyId=companyId;
    	this.fstart=fstart;
    	this.fend=fend;
    	this.jpiao=jpiao;
    	this.hpiao=hpiao;
    	this.starttime=starttime;
    	this.endtime=endtime;
    	this.jprice=jprice;
    	this.hprice=hprice;
    }
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", companyId=" + companyId + ", fstart=" + fstart + ", fend=" + fend
				+ ", jpiao=" + jpiao + ", starttime=" + starttime + ", endtime=" + endtime + ", jprice=" + jprice
				+ ", hprice=" + hprice + ", hpiao=" + hpiao ;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getJprice() {
		return jprice;
	}

	public void setJprice(Integer jprice) {
		this.jprice = jprice;
	}

	public Integer getHprice() {
		return hprice;
	}

	public void setHprice(Integer hprice) {
		this.hprice = hprice;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getFstart() {
		return fstart;
	}

	public void setFstart(String fstart) {
		this.fstart = fstart;
	}

	public String getFend() {
		return fend;
	}

	public void setFend(String fend) {
		this.fend = fend;
	}

	public Integer getJpiao() {
		return jpiao;
	}

	public void setJpiao(Integer jpiao) {
		this.jpiao = jpiao;
	}

	public Integer getHpiao() {
		return hpiao;
	}

	public void setHpiao(Integer hpiao) {
		this.hpiao = hpiao;
	}

	public Integer getFstate() {
		return fstate;
	}

	public void setFstate(Integer fstate) {
		this.fstate = fstate;
	}

}
