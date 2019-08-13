package com.books.model;

import java.io.Serializable;
import java.sql.Date;

public class AccountRecord implements Serializable{

	
	private Integer recordid;//借书ID
	private Integer userid;//用户ID
	private Double money;//变动金额
	private Date changetime;//变动时间
	private Integer type;//变动类型
	
	
	
	
	public AccountRecord() {
		super();
	}
	
	public AccountRecord(Integer userid, Double money, Date changetime, Integer type) {
		super();
		this.userid = userid;
		this.money = money;
		this.changetime = changetime;
		this.type = type;
	}

	public Integer getRecordid() {
		return recordid;
	}
	public void setRecordid(Integer recordid) {
		this.recordid = recordid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Date getChangetime() {
		return changetime;
	}
	public void setChangetime(Date changetime) {
		this.changetime = changetime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AccountRecord [recordid=" + recordid + ", userid=" + userid + ", money=" + money + ", changetime="
				+ changetime + ", type=" + type + "]";
	}
	
	
}
