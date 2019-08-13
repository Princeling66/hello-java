package com.books.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.books.dao.UserDao;
import com.books.model.User;
import com.books.service.IUserService;
@Service
public class UserServiceimpl implements IUserService{

	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public User getUser(User loginUser) throws Exception {

		return userDao.getUser(loginUser);
	}


	//根据用户ID增加欠费金额
		public void updateMoney(User user) throws Exception {
			userDao.updateMoney(user);
		}
	
		//根据用户id查询有没有欠费
		public Double getMoney(Integer userid)throws Exception{
			return userDao.getMoney(userid);
		}
		//修改欠费用户状态
		public void updateUser(Integer userid)throws Exception{
			 userDao.updateUser(userid);
		}
		//修改欠费用户状态
		public void updateUser2(Integer userid)throws Exception{
			 userDao.updateUser2(userid);
		}
		//根据用户ID清零欠费金额
		public void updateMZ(Integer userid)throws Exception{
			userDao.updateMZ(userid);
		}
		
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	





	

}
