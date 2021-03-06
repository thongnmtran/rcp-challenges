package com.kmstechnology.todolist.core.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

public class TodoList {
	private List<Todo> todoList;

	public TodoList() {
		super();
		this.todoList = new ArrayList<Todo>();
	}

	public Todo add(String todo, Composite composite) {
		Todo newTodo = new Todo(todo, composite);
		this.todoList.add(newTodo);
		return newTodo;
	}

	public List<Todo> get() {
		return this.todoList;
	}
}
