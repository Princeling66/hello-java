package com.books.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.books.model.Book;
import com.books.service.IBookService;
import com.books.model.Page;

@Controller
public class ShowBookController {
@Autowired
	private IBookService bookService;
@RequestMapping("ShowBook.do")
	public String showBook(HttpServletRequest request){
	// 页面搜索数据
			String bookname = request.getParameter("bookname");
			String author = request.getParameter("author");
	// 分页数据 获取要显示的页码
			String p = request.getParameter("page");
			int currentPage = 1;// 默认第一页
			if (p != null) {
				currentPage = Integer.parseInt(p);
			}
			int pageSize = 3;// 假设每页显示3条记录	
			// 创建Book对象和Page对象封装响应的所有信息
			Book book=new Book();
			book.setBookname(bookname);
			book.setAuthor(author);
			Page page = new Page(currentPage, pageSize);
			Map<String, Object> map = new HashMap();
			map.put("page", page);
			map.put("book", book);
			map.put("begin", (currentPage-1)*pageSize);
			//调用业务层方法
	try {
		List<Book>	al = bookService.getBook(map);
		int total= bookService.getPage();
		int totalPage=total%page.getPageSize()==0?total/page.getPageSize():(total/page.getPageSize())+1;
		page.setPage(totalPage);
		page.setData(al);
		request.setAttribute("pa", page);
		return "main.jsp";
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
	
	
}
