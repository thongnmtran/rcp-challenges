package com.kmstechnology.todolist.app.handlers;

import com.kmstechnology.todolist.app.parts.TodoAppPart;

public class TodoMoveUpListener extends TodoMoveListener {

	public TodoMoveUpListener(TodoAppPart todoAppPart) {
		super(todoAppPart);
		super.move = TodoMoveEnum.UP;
	}
}
