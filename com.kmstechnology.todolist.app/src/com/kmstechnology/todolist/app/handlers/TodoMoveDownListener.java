package com.kmstechnology.todolist.app.handlers;

import com.kmstechnology.todolist.app.parts.TodoAppPart;

public class TodoMoveDownListener extends TodoMoveListener {
	
	public TodoMoveDownListener(TodoAppPart todoAppPart) {
		super(todoAppPart);
		super.move = TodoMoveEnum.DOWN;
	}
}
