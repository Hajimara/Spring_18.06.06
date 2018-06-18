package org.yogiyo.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yogiyo.app.service.domain.UserVO;
import org.yogiyo.app.service.user.UserDao;
import org.yogiyo.app.service.user.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;
	
	
	@Override
	public UserVO getUser(String userAddress)throws Exception{	
		return userDao.getUser(userAddress);
	}

}
