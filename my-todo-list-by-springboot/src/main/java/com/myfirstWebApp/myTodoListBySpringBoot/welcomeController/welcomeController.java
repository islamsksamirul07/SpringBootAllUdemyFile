package com.myfirstWebApp.myTodoListBySpringBoot.welcomeController;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.myfirstWebApp.myTodoListBySpringBoot.login.AuthenticateService;

@Controller

public class welcomeController {
//	@Autowired
//	private AuthenticateService authenticate;
//	public welcomeController(AuthenticateService authenticate) {
//		super();
//		this.authenticate=authenticate;
//	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String wlcomeFun(ModelMap model) {
		model.put("name", getLoggedInUserName());
		return "welcome";
	}
			
	
//	etir dara amra je user name dara login korbo seti autometically deteacted hoye jabe
	private String getLoggedInUserName() {
		org.springframework.security.core.Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}
	
	
	/*
	 * @PostMapping("login") public String welcome1(@RequestParam String
	 * name, @RequestParam String password, ModelMap model) {
	 * if(authenticate.serviceReturn(name,password)) { model.put("name", name);
	 * model.put("pass", password);
	 * 
	 * return "welcome"; }
	 * 
	 * model.put("error", "Enter your valid Name Or Password"); return "loginUser";
	 * }
	 */

}
