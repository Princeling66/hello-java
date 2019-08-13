package com.books.dao;

import java.util.List;
import java.util.Map;

import com.books.model.Book;

public interface BookDao {

	/**
	 * 显示图书的和分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Book> getBook(Map<String,Object> map)throws Exception;
	public int getPage()throws Exception;
	//通过图书 id更改图书状态
	public void updateBookStatus(Integer bookid)throws Exception;
	
	public void updateStatus(Integer bookid)throws Exception;
	
}
