package com.books.model;

import java.io.Serializable;
import java.sql.Date;

public class BookRecord implements Serializable{

	private Integer recordid;
	private Integer userid;
	private Integer bookid;
	private Date lendtime;//借书时间
	private Date returntime;//还书时间
	private Date expiretime;//到期时间
	//剩余天数
	private long day;
	
	
	
	public BookRecord() {
		super();
	}
	
	
	public BookRecord(Integer recordid, Date returntime) {
		super();
		this.recordid = recordid;
		this.returntime = returntime;
	}


	public BookRecord(Integer userid, Integer bookid, Date lendtime, Date expiretime) {
		super();
		this.userid = userid;
		this.bookid = bookid;
		this.lendtime = lendtime;
		this.expiretime = expiretime;
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
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public Date getLendtime() {
		return lendtime;
	}
	public void setLendtime(Date lendtime) {
		this.lendtime = lendtime;
	}
	public Date getReturntime() {
		return returntime;
	}
	public void setReturntime(Date returntime) {
		this.returntime = returntime;
	}
	public Date getExpiretime() {
		return expiretime;
	}
	public void setExpiretime(Date expiretime) {
		this.expiretime = expiretime;
	}
	
	public long getDay() {
		return day;
	}
	public void setDay(long day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "BookRecord [recordid=" + recordid + ", userid=" + userid + ", bookid=" + bookid + ", lendtime="
				+ lendtime + ", returntime=" + returntime + ", expiretime=" + expiretime + ", day=" + day + "]";
	}
	
	
	
	
	
	
}
