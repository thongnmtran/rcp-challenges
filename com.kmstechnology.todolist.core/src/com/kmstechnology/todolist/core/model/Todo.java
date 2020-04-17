package com.kmstechnology.todolist.core.model;

import org.eclipse.swt.widgets.Composite;

public class Todo {
	private String todoString;
	private Composite composite;

	public Todo() {
		super();
	}

	public Todo(String todoString, Composite composite) {
		super();
		this.todoString = todoString;
		this.composite = composite;
	}

	public String getText() {
		return todoString;
	}

	public void setTodo(String todoString) {
		this.todoString = todoString;
	}

	public Composite getComposite() {
		return composite;
	}

	public void setComposite(Composite composite) {
		this.composite = composite;
	}
}
