package com.myfirstWebApp.myTodoListBySpringBoot.todoAllMain;

import java.time.LocalDate;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


//@Controller

public class todoController {
	
	private TodoService todoService;

	public todoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("todos-list")
	public String listAllTodos(ModelMap model) {
		String userName = getLoggedInUserName();
		List <Todo> todos = todoService.findByUsername(userName);
		
		model.addAttribute("todos", todos);
		return "ListTodos";

	}
	
//	@RequestMapping(value="add-todo", method=RequestMethod.GET)
//	public String showNewTodoPage() {
//		
//		
//		return "todo";
//
//	}
	
//	er dara amra direct todo te value pathabo web e te ar thakbe na(GET)
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		
		String username=getLoggedInUserName();
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";

	}
	
//	@RequestMapping(value="add-todo", method=RequestMethod.POST)
//	public String AddNewTodo(@RequestParam String description, ModelMap model) {
//		String username=(String)model.get("name");
//		todoService.addTodo(username, description, LocalDate.now(), true);
//		
//		
//		
//		
////		er dara amra ekti particular url e jach6i "redirect:" er dara kono jsp page e na 
//		return "redirect:todos-list";
//
//	}

//	er dara amra direct todo te value pathabo web e te ar thakbe na(GET)
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
//	@valid and bindingRestut te validation add korar jonno
	public String AddNewTodo( ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username=getLoggedInUserName();
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), true);
		
		
		
		
//		er dara amra ekti particular url e jach6i "redirect:" er dara kono jsp page e na 
		return "redirect:todos-list";

	}
	
//	eta todo delete korar jonno
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		System.out.print("working");
		return "redirect:todos-list";
	}
	
//	et todo tike update korar jonno eti GET hole
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdatePage(@RequestParam int id,ModelMap model) {
		Todo todo=todoService.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
//	et todo tike update korar jonno. eti POST hole
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username=getLoggedInUserName();
		todo.setName(username);
		todoService.updateTodo(todo);
		return "redirect:todos-list";
		
	}


	
//	eti dara amra je user ti login hoye6e tar name use korbo
	private String getLoggedInUserName() {
		org.springframework.security.core.Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
		
}
