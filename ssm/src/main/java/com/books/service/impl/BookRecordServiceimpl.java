package com.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.books.dao.BookRecordDao;
import com.books.dao.UserDao;
import com.books.model.BookRecord;
import com.books.model.User;
import com.books.service.IBookRecordService;

@Service
public class BookRecordServiceimpl implements IBookRecordService {
	@Autowired
	private BookRecordDao bookrecordDao;
	@Autowired
	private UserDao userDao;
	/**
	 * 借书记录
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<BookRecord> getBookRecord(Integer userid) throws Exception {
		List<BookRecord> al=bookrecordDao.getBookRecord(userid);
		return al;
	}
	
	//根据用户id查询借书记录条数
	public int getBookCount(Integer userid) throws Exception {
		int count=bookrecordDao.getBookCount(userid);
		return count;
	}
	//租书 增加借书记录
	@Transactional(propagation = Propagation.REQUIRED)
	public int addBookRecord(BookRecord br) throws Exception {
		//根据用户id查询借书记录条数
		int count=getBookCount(br.getUserid());
		//根据用户id查询有没有欠费
		Double money=userDao.getMoney(br.getUserid());
		if(money>=0&&count<5) {
			int n=bookrecordDao.addBookRecord(br);
			return n;
		}
		return 0;
	}
	//根据借书id查询借书记录
		public Integer getSingeBR(Integer recordid) throws Exception {
			Integer bookid=bookrecordDao.getSingeBR(recordid);
			return bookid;
		}
		//修改租书记录
		public void updateBookRecord(BookRecord br) throws Exception {
			bookrecordDao.updateBookRecord(br);
		}
	
	public BookRecordDao getBookrecordDao() {
		return bookrecordDao;
	}

	public void setBookrecordDao(BookRecordDao bookrecordDao) {
		this.bookrecordDao = bookrecordDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	

	
}
