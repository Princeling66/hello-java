package com.books.dao;

import com.books.model.User;

public interface UserDao {
/**
 * 登录校验
 * @param loginUser
 * @return
 * @throws Exception
 */
	public User getUser(User loginUser) throws Exception;
	//根据用户ID增加欠费金额
	public void updateMoney(User user)throws Exception;
	//根据用户id查询有没有欠费
	public Double getMoney(Integer userid)throws Exception;
	//修改欠费用户状态
	public void updateUser(Integer userid)throws Exception;
	
	//修改欠费用户状态
		public void updateUser2(Integer userid)throws Exception;
	
	//根据用户ID清零欠费金额
		public void updateMZ(Integer userid)throws Exception;
}
