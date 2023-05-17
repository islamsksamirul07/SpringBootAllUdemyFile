package com.myfirstWebApp.myTodoListBySpringBoot.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginTest {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	@RequestMapping("/loginTesting")
	public String logingTesting(@RequestParam String name, ModelMap model) {
		
		logger.debug("hey "+name+" you debug is displaying is here");
		System.out.println("hey "+name);
		model.put("name1", name);
		return "page2";
	}

}
