/*
 * package com.myfirstWebApp.myTodoListBySpringBoot.login;
 * 
 * //import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * @Controller
 * 
 * public class login { // @Autowired private AuthenticateService authenticate;
 * public login(AuthenticateService authenticate) { super();
 * this.authenticate=authenticate; }
 * 
 * @RequestMapping(value="login", method=RequestMethod.GET) public String
 * loginFun() { return "loginUser"; }
 * 
 * 
 * @PostMapping("login") public String welcome1(@RequestParam String
 * name, @RequestParam String password, ModelMap model) {
 * if(authenticate.serviceReturn(name,password)) { model.put("name", name);
 * model.put("pass", password);
 * 
 * return "welcome"; }
 * 
 * model.put("error", "Enter your valid Name Or Password"); return "loginUser";
 * }
 * 
 * }
 */