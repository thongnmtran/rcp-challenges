package com.kmstechnology.todolist.app.handlers;

import java.util.List;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;

import com.kmstechnology.todolist.app.parts.TodoAppPart;
import com.kmstechnology.todolist.core.model.Todo;

public class TodoDeleteListener implements SelectionListener {
	private final TodoAppPart todoAppPart;

	public TodoDeleteListener(TodoAppPart todoAppPart) {
		this.todoAppPart = todoAppPart;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Button currentButton = (Button) e.getSource();
		Todo selectedTodo = (Todo) currentButton.getData();
		List<Todo> todoList = todoAppPart.getToDoList().get();
		if (selectedTodo != null && selectedTodo.getComposite() != null) {
			todoList.remove(selectedTodo);
			selectedTodo.getComposite().dispose();
		}
		todoAppPart.refreshLayout();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}
}
