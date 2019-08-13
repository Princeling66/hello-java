package com.books.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.books.model.AccountRecord;
import com.books.model.User;
import com.books.service.IAccountRecordService;
import com.books.service.IUserService;
/**
 * 补交逾期欠费金额，欠费金额清0，并且 添加记录
 * @author 
 *
 */
@Controller
public class PayController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IAccountRecordService accountrecordService;
	
	@RequestMapping("pay.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String pay(HttpServletRequest request) {
				//获得当前session作用域中User对象的ID
				Integer userid = ((User) request.getSession().getAttribute("curuser")).getUserid();
				try {
					//欠费金额清0
					userService.updateMZ(userid);
					userService.updateUser2(userid);
					//添加补交逾期费用记录
					int type=2;
					double owing_money=0;
					//获取当前时间
					long totalMilliSeconds = System.currentTimeMillis();
					Date changetime=new Date(totalMilliSeconds);
					AccountRecord ar=new AccountRecord(userid,owing_money,changetime,type);
					accountrecordService.addAccountRecord(ar);
					request.setAttribute("message", "缴费成功");
					return "user/pay.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "error.jsp";
				
				
				
	}

	
	
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IAccountRecordService getAccountrecordService() {
		return accountrecordService;
	}

	public void setAccountrecordService(IAccountRecordService accountrecordService) {
		this.accountrecordService = accountrecordService;
	}
	
	
	
	
}
