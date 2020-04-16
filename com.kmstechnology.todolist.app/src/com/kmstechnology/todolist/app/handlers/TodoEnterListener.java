package com.kmstechnology.todolist.app.handlers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Text;

import com.kmstechnology.todolist.app.parts.TodoAppPart;

public class TodoEnterListener implements KeyListener {
	private final TodoAppPart todoAppPart;
	private final Text txtTodo;

	public TodoEnterListener(Text textTodo, TodoAppPart todoAppPart) {
		super();
		this.txtTodo = textTodo;
		this.todoAppPart = todoAppPart;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
			todoAppPart.handleAddTodo(txtTodo.getText());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
		}
	}

}
