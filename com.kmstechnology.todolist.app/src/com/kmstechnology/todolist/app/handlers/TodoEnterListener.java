package com.kmstechnology.todolist.app.handlers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Text;

import com.kmstechnology.todolist.app.parts.TodoAppPart;

public class TodoEnterListener implements KeyListener {
	private final TodoAppPart todoAppPart;
	private final Text txtTodo;

	public TodoEnterListener(TodoAppPart todoAppPart) {
		super();
		this.txtTodo = todoAppPart.getTxtInput();
		this.todoAppPart = todoAppPart;
	}

	@Override
	public void keyPressed(KeyEvent event) {
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (event.keyCode == SWT.CR || event.keyCode == SWT.KEYPAD_CR) {
			this.todoAppPart.renderNewTodo();
			this.txtTodo.setText("");
		}
	}
}
