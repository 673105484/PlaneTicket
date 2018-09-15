package com.ljn.model;

import java.util.Date;

public class Users {
	private Integer usersId;
	private String uname;
	private String truename;
	private String pwd;
	private String sex;
	private String cernum;
	private String mail;
	private String phone;
	private Date date;
    public  Users() {
	  
    }
	public Users(String uname, String truename, String pwd, String sex, String cernum, String mail,
			String phone) {
		this.uname = uname;
		this.truename = truename;
		this.pwd = pwd;
		this.sex = sex;
		this.cernum = cernum;
		this.mail = mail;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", uname=" + uname + ", truename=" + truename + ", pwd=" + pwd + ", sex="
				+ sex + ", cernum=" + cernum + ", mail=" + mail + ", phone=" + phone + ", date=" + date + "]";
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCernum() {
		return cernum;
	}

	public void setCernum(String cernum) {
		this.cernum = cernum;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
