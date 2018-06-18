package org.yogiyo.app.web.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	public MainController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String getMain(Model model)throws Exception{
		
		System.out.println("/main get...");
		
		return "main/main";
	}

}
