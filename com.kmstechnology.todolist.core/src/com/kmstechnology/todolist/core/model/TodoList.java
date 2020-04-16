package com.kmstechnology.todolist.core.model;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
	private final List<Todo> todoList = new ArrayList<Todo>();

	public TodoList() {
		super();
	}

	public Todo add(String todo) {
		Todo newTodo = new Todo(todo);
		this.todoList.add(newTodo);
		return newTodo;
	}

	public List<Todo> get() {
		return this.todoList;
	}
}
