package com.ljn.model;

import java.util.Date;

public class BookTicket {
	private Integer bookTicketId;
	private Integer hyid;
	private String uname;
	private String cernum;
	private String fid;
	private String phone;
	private String zwNumber;
	private Integer jptype;
	private Date booktime;

	@Override
	public String toString() {
		return "BookTicket [bookTicketId=" + bookTicketId + ", hyid=" + hyid + ", uname=" + uname + ", cernum=" + cernum
				+ ", flightTimeId=" + fid + ", phone=" + phone + ", zwNumber=" + zwNumber + ", jptype="
				+ jptype + ", booktime=" + booktime + ", insure=" + insure + ", jpstate=" + jpstate + "]";
	}

	public Integer getBookTicketId() {
		return bookTicketId;
	}

	public void setBookTicketId(Integer bookTicketId) {
		this.bookTicketId = bookTicketId;
	}

	public Integer getHyid() {
		return hyid;
	}

	public void setHyid(Integer hyid) {
		this.hyid = hyid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getCernum() {
		return cernum;
	}

	public void setCernum(String cernum) {
		this.cernum = cernum;
	}



	public String getFid() {
		return fid;
	}

	public void setFid(String fid2) {
		this.fid = fid2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZwNumber() {
		return zwNumber;
	}

	public void setZwNumber(String zwNumber) {
		this.zwNumber = zwNumber;
	}

	public Integer getJptype() {
		return jptype;
	}

	public void setJptype(Integer jptype) {
		this.jptype = jptype;
	}

	public Date getBooktime() {
		return booktime;
	}

	public void setBooktime(Date booktime) {
		this.booktime = booktime;
	}

	public Integer getInsure() {
		return insure;
	}

	public void setInsure(Integer insure) {
		this.insure = insure;
	}

	public Integer getJpstate() {
		return jpstate;
	}

	public void setJpstate(Integer jpstate) {
		this.jpstate = jpstate;
	}

	private Integer insure;
	private Integer jpstate;
}
