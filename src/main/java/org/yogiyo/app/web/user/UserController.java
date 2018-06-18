package org.yogiyo.app.web.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yogiyo.app.service.domain.UserVO;
import org.yogiyo.app.service.user.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserController() {
		// TODO Auto-generated constructor stub
		
		System.out.println(this.getClass());
	}
	/*
	 * login
	 * */
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginGet(HttpSession httpSession, Model model)throws Exception{
		
		System.out.println("user/login : GET...");
		
		return "user/login";
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@ModelAttribute("user")UserVO user, HttpSession httpSession, Model model)throws Exception{
		
		System.out.println("user/login : POST ...");
		
		UserVO userInfo = userService.getUser(user.getUserAddress());
		
		System.out.println("userInfo : "+userInfo);
		
		if(user.getUserPassword().equals(userInfo.getUserPassword())) {
			System.out.println("userInfo : "+userInfo);
			
			httpSession.setAttribute("user", userInfo);
		}
		
		return "main/main";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) throws Exception{
		
			httpSession.invalidate();
		
		return "redirect:/";
	}
		
	

}

