package com.myfirstWebApp.myTodoListBySpringBoot.todoAllMain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static int todosCount=0;
	public static List<Todo> todos=new ArrayList<>();
	static {
		todos.add(new Todo(++todosCount,"Samirul","learn Deep in Spring Boot",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"Samirul","learn Deep in React",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount,"Samirul","learn Deep in Redis",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"Samirul","learn Deep in JavaScript",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"Samirul","learn Deep in full Stack",LocalDate.now().plusYears(2),false));
//		todos.appand(new todo(5,"Sahil","learn Deep in full Stack",LocalDate.now().plusYears(2),false));
	}
	
	

//	public List<todo> findByUsername(String username){
//		System.out.println(todos);
//		return todos;
//	}
	
//	er dara particular je username ti chai setie asbe
	public List<Todo> findByUsername(String username){
		Predicate <?super Todo> predicate=
				todo->todo.getName().equalsIgnoreCase(username);
				
		
		System.out.println(todos);
		return todos.stream().filter(predicate).toList();
	}
	
	
//	eta web theke todo add korar jonno
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
	
		Todo oneTodo=new Todo(++todosCount,username, description, targetDate, done);
		todos.add(oneTodo);
	}
	
//	eti delete korar jonno. eti todoController theke call hobe 
	
	public void deleteById(int id) {
		Predicate < ? super Todo> predicate= todo->todo.getId()==id;
		todos.removeIf(predicate);
	}

//	eti Update korar jonno. eti todoController theke call hobe. eti GET jodi hoi Update tokhon execute hobe
	public Todo findById(int id) {
		Predicate < ? super Todo> predicate= todo->todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
//	eti Update korar jonno. eti todoController theke call hobe. eti POST jodi hoi Update tokhon execute hobe
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
