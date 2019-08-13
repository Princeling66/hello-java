package com.books.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.books.dao.BookDao;
import com.books.model.Book;
import com.books.service.IBookService;

@Service
public class BookServiceimpl implements IBookService {

	@Autowired
	public BookDao bookDao;

/**
 * 显示图书的和分页
 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Book> getBook(Map<String,Object> map) throws Exception {
		List<Book> al=  bookDao.getBook(map);
		return al ;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public int getPage() throws Exception {
		int total =bookDao.getPage();
		return total;
		
	}
	
	public void updateBookStatus(Integer bookid) throws Exception {
		bookDao.updateBookStatus(bookid);
	}
	
	
	
	public void updateStatus(Integer bookid) throws Exception {
		bookDao.updateStatus(bookid);
		
	}
	
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	
	

	






	




















	

}
