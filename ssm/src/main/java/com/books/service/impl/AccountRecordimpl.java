package com.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.books.dao.AccountRecordDao;
import com.books.model.AccountRecord;
import com.books.service.IAccountRecordService;

@Service
public class AccountRecordimpl implements IAccountRecordService {

	@Autowired
	private AccountRecordDao accountrecordDao;
	/**
	 * 查询金额变动记录
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<AccountRecord> getAccountRecord(Integer userid) throws Exception {
		List<AccountRecord> al = accountrecordDao.getAccountRecord(userid);
		return al;
	}
	
	/**
	 * 增加金额变动记录
	 * @param ar
	 * @throws Exception
	 */
	public void addAccountRecord(AccountRecord ar)throws Exception{
		 accountrecordDao.addAccountRecord(ar);
	}

	
	
	public AccountRecordDao getAccountrecordDao() {
		return accountrecordDao;
	}

	public void setAccountrecordDao(AccountRecordDao accountrecordDao) {
		this.accountrecordDao = accountrecordDao;
	}

}
