package com.books.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class User implements Serializable {

	private Integer userid;
	private String username;
	private String password;
	private String idcard;
	private String phone;
	private Date createtime;
	private Integer status;
	private Double owing_money;
	public User() {
		super();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getOwing_money() {
		return owing_money;
	}

	public void setOwing_money(Double owing_money) {
		this.owing_money = owing_money;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", idcard=" + idcard
				+ ", phone=" + phone + ", createtime=" + createtime + ", status=" + status + ", owing_money="
				+ owing_money + "]";
	}


	

}
