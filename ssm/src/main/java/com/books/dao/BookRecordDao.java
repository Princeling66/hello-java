package com.books.dao;

import java.util.List;

import com.books.model.BookRecord;

public interface BookRecordDao {
/**
 * 查询借书记录
 * @param userid
 * @return
 * @throws Exception
 */
	public List<BookRecord> getBookRecord(Integer userid)throws Exception;
	//根据用户id查询借书记录条数
	public int getBookCount(Integer userid)throws Exception;
	//租书 增加借书记录
	public int addBookRecord(BookRecord br)throws Exception;
	//根据借书id查询借书记录
	public Integer getSingeBR(Integer recordid)throws Exception;
	//修改租书记录
	public void updateBookRecord(BookRecord br)throws Exception;
}
