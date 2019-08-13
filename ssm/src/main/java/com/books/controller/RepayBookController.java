package com.books.controller;

import java.sql.Date;
import java.util.List;

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
import com.books.service.IUserService;
/**
 * 还书
 * @author 
 *
 */
@Controller
public class RepayBookController {

	@Autowired
	private IBookRecordService bookrecordService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("repaybook.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String RepayBook(HttpServletRequest request) {
		try {
					//获得借书记录编号
					String idstr=request.getParameter("idstr");
					//获得还书时间毫秒数
					Long date=Long.valueOf(request.getParameter("now"));
					Date returntime=new Date(date);
					//获得借书记录编号数组
					String[]arr=idstr.split(",");
					for(int x=0;x<arr.length;x++) {
					Integer	recordid=Integer.valueOf(arr[x]);
					BookRecord br = new BookRecord(recordid,returntime);
						//修改借书记录
						bookrecordService.updateBookRecord(br);
						//根据借书ID查询图书id
						Integer bookid=bookrecordService.getSingeBR(recordid);
						//根据bookid修改图书在馆状态
						bookService.updateStatus(bookid);
					}
					request.setAttribute("message", "还书成功");
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

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
