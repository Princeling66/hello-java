package com.books.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.books.model.AccountRecord;
import com.books.model.BookRecord;
import com.books.model.User;
import com.books.service.IAccountRecordService;
import com.books.service.IBookRecordService;
import com.books.service.IUserService;

@Controller
public class LoginController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IBookRecordService bookrecordService;
	@Autowired
	private IAccountRecordService accountrecordService;
	@RequestMapping("login.do")
	@Transactional(propagation = Propagation.REQUIRED)
	public String login(User loginUser,HttpSession session) {
		//查询数据库验证账号和密码是否合法
	try {
		User user = userService.getUser(loginUser);
		if(user==null) {
			session.setAttribute("error", "账号密码错误！");
			return "login.jsp";
		}else {
			//根据id更新欠费
			//通过用户id查询借书记录
			List<BookRecord> al=bookrecordService.getBookRecord(user.getUserid());
			System.out.println(al);
			//遍历记录查询逾期
			for(int i=0;i<al.size();i++) {
				//根据是否逾期修改账户欠费金额
				if(al.get(i).getReturntime()==null&&al.size()>0) {
					long lendtime=al.get(i).getLendtime().getTime();//借书时间
					long expiretime=al.get(i).getExpiretime().getTime();//到期时间
					//获取当前时间
					long totalMilliSeconds = System.currentTimeMillis();
					Date changetime=new Date(totalMilliSeconds);
					//剩余天数
					long day=(expiretime-totalMilliSeconds)/(1000 * 60 * 60 * 24);
					if(day<0) {//如果逾期
						double owing_money=day*0.2d;
						//根据用户id增加欠费金额
						user.setOwing_money(owing_money);
						user.setUserid(user.getUserid());
						userService.updateMoney(user);
						//修改欠费用户状态
						userService.updateUser(user.getUserid());
						//增加金额变动记录
						int type=1;
						AccountRecord ar=new AccountRecord(user.getUserid(),owing_money,changetime,type);
						accountrecordService.addAccountRecord(ar);
					}
				}
			}
			session.setAttribute("curuser", user);
			return "index.jsp";
		}
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



	public IAccountRecordService getAccountrecordService() {
		return accountrecordService;
	}











	public void setAccountrecordService(IAccountRecordService accountrecordService) {
		this.accountrecordService = accountrecordService;
	}
	
	
}
