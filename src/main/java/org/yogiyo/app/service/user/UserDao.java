package org.yogiyo.app.service.user;

import java.util.Map;

import org.yogiyo.app.service.domain.UserVO;

public interface UserDao {
	
	public UserVO getUser(String userAddress)throws Exception;
	
	

}
