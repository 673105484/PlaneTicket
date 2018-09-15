package com.ljn.model;

public class Admin {
	private Integer adminId;
	private String uname;
	private String pwd;

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", uname=" + uname + ", pwd=" + pwd + "]";
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
