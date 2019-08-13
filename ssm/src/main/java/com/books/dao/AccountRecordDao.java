package com.books.dao;

import java.util.List;

import com.books.model.AccountRecord;

public interface AccountRecordDao {

	/**
	 * 查询金额变动记录
	 */
	public List<AccountRecord> getAccountRecord(Integer userid)throws Exception;
	/**
	 * 增加金额变动记录
	 * @param ar
	 * @throws Exception
	 */
	public void addAccountRecord(AccountRecord ar)throws Exception;
	
}
