package com.kmstechnology.todolist.app.handlers;

import java.util.List;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.kmstechnology.todolist.app.parts.TodoAppPart;
import com.kmstechnology.todolist.core.model.Todo;

public class TodoMoveListener implements SelectionListener {
	protected final TodoAppPart todoAppPart;
	protected TodoMoveEnum move;

	public TodoMoveListener(TodoAppPart todoAppPart) {
		super();
		this.todoAppPart = todoAppPart;
	}

	@Override
	public void widgetSelected(SelectionEvent event) {
		List<Todo> todoList = todoAppPart.getToDoList().get();
		if (todoList.size() <= 1) {
			return;
		}
		Button currentButton = (Button) event.getSource();
		Todo selectedTodo = (Todo) currentButton.getData();
		int currentTodoIndex = todoList.indexOf(selectedTodo);
		String swrapVariable = selectedTodo.getText();
		Todo targetTodo = new Todo();

		switch (move) {
		case UP:
			if (currentTodoIndex > 0) {
				targetTodo = todoList.get(currentTodoIndex - 1);
				selectedTodo.setText(targetTodo.getText());
				targetTodo.setText(swrapVariable);
				setElementLabelText(selectedTodo);
				setElementLabelText(targetTodo);
			}
			break;
		case DOWN:
			if (currentTodoIndex < todoList.size() - 1) {
				targetTodo = todoList.get(currentTodoIndex + 1);
				selectedTodo.setText(targetTodo.getText());
				targetTodo.setText(swrapVariable);
				setElementLabelText(selectedTodo);
				setElementLabelText(targetTodo);
			}
			break;
		default:
			break;
		}
		todoAppPart.refreshLayout();
	}

	private void setElementLabelText(Todo todo) {
		for (Control child : todo.getComposite().getChildren()) {
			if (child instanceof Label) {
				((Label) child).setText(todo.getText());
			}
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

}
