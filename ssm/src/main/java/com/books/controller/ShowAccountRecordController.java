package com.books.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.books.model.AccountRecord;
import com.books.model.User;
import com.books.service.IAccountRecordService;
/**
 * 显示金额变动记录页面
 * @author 
 *
 */
@Controller
public class ShowAccountRecordController {

	@Autowired
	private IAccountRecordService accountrecordService;
	@RequestMapping("ShowAR.do")//获取金额变动记录
	public String getAccountRecord(HttpServletRequest request) {
		//获得当前session作用域中User对象的ID
	User user = (User) request.getSession().getAttribute("curuser") ;
	try {
		List<AccountRecord> al=accountrecordService.getAccountRecord(user.getUserid());
		request.setAttribute("AccountRecord", al);
		return "user/accountrecord.jsp";
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "error.jsp";
		
		
		
	}

	public IAccountRecordService getAccountrecordService() {
		return accountrecordService;
	}

	public void setAccountrecordService(IAccountRecordService accountrecordService) {
		this.accountrecordService = accountrecordService;
	}
	
	
}
