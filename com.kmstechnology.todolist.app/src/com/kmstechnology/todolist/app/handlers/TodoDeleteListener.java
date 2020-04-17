package com.kmstechnology.todolist.app.handlers;

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
		if(selectedTodo.getComposite() != null){
			selectedTodo.getComposite().dispose();
		}
		todoAppPart.refreshLayout();
	}
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}
}
