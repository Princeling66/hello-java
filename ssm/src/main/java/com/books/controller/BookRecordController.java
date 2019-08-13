package com.books.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.books.model.BookRecord;
import com.books.model.User;
import com.books.service.IBookRecordService;
import com.books.service.IBookService;

@Controller
public class BookRecordController {

	@Autowired
	private IBookRecordService bookrecordService;
	@Autowired
	private IBookService bookService;
	//租书
	@RequestMapping("recordbook.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String RecordBook(HttpServletRequest request) {
		//获得当前session作用域中User对象的ID
	User user = (User) request.getSession().getAttribute("curuser");
	//获得图书ID
	Integer bookid=Integer.valueOf(request.getParameter("bookid"));
		//获得租书时间毫秒数
		long date=Long.valueOf(request.getParameter("now"));
		//获得到期时间
		Date expiretime=new Date(date+2592000000L);
		//获得租书时间
		Date lendtime = new Date(date);
		BookRecord br=new BookRecord(user.getUserid(),bookid,lendtime,expiretime);
		try {
			int a=bookrecordService.addBookRecord(br);
			if(a!=0) {
				request.setAttribute("message", "租书成功！");
				bookService.updateBookStatus(bookid);
				return "main.jsp";
			}else {
				request.setAttribute("message", "您已欠费请缴清费用再租书");
				return "main.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error.jsp";
		
	}
	
	
	
	
	
	
	
	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}


	public IBookRecordService getBookrecordService() {
		return bookrecordService;
	}

	public void setBookrecordService(IBookRecordService bookrecordService) {
		this.bookrecordService = bookrecordService;
	}
	
	
}
