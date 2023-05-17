package com.myfirstWebApp.myTodoListBySpringBoot.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {
	public boolean serviceReturn(String name, String password) {
		
//		if(name=="Samirul" && password=="test")
//			return true;
//		else
//			return false;
		
		boolean isValidUsername= name.equalsIgnoreCase("Samirul");
		boolean isValidPassword=password.equalsIgnoreCase("test");
		
		return isValidUsername && isValidPassword;
	}

}
