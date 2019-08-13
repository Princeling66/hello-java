package com.books.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.books.model.BookRecord;
import com.books.model.User;
import com.books.service.IBookRecordService;
import com.books.service.IUserService;
@Controller
public class ShowBookRecordController {
	@Autowired
	private IBookRecordService bookrecordService;
	@RequestMapping("ShowBR.do")
	public String getBookRecord(HttpServletRequest request,HttpSession session) {
		//获得当前session作用域中User对象的ID
		Integer userid = ((User) request.getSession().getAttribute("curuser")).getUserid();
		try {
			List<BookRecord> al=bookrecordService.getBookRecord(userid);
			for(int i=0;i<al.size();i++) {
				long lendtime=al.get(i).getLendtime().getTime();//借书时间
				long expiretime=al.get(i).getExpiretime().getTime();//到期时间
				//获取当前时间
				long totalMilliSeconds = System.currentTimeMillis();
				//剩余天数
				long day=(expiretime-totalMilliSeconds)/(1000 * 60 * 60 * 24);
				al.get(i).setDay(day);
			}
			request.setAttribute("BookRecord", al);
			return "user/bookrecord.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error.jsp";
		
	}
	public IBookRecordService getBookrecordService() {
		return bookrecordService;
	}
	public void setBookrecordService(IBookRecordService bookrecordService) {
		this.bookrecordService = bookrecordService;
	}
	
	
	
}
