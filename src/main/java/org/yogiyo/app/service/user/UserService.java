package org.yogiyo.app.service.user;

import org.yogiyo.app.service.domain.UserVO;

public interface UserService {
	
	public UserVO getUser(String userAddress)throws Exception;

}
