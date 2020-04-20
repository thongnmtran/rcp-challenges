package com.kmstechnology.todolist.app.parts;

import javax.annotation.PostConstruct;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.kmstechnology.todolist.app.handlers.TodoDeleteListener;
import com.kmstechnology.todolist.app.handlers.TodoEnterListener;
import com.kmstechnology.todolist.app.handlers.TodoMoveDownListener;
import com.kmstechnology.todolist.app.handlers.TodoMoveUpListener;
import com.kmstechnology.todolist.core.icon.IconHandler;
import com.kmstechnology.todolist.core.model.Todo;
import com.kmstechnology.todolist.core.model.TodoList;

public class TodoAppPart {

	private Text txtInput;
	private TodoList todoList = new TodoList();
	private Composite todoListComposite;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		txtInput = new Text(parent, SWT.BORDER);
		txtInput.setMessage("Enter new todo...");
		txtInput.addKeyListener(new TodoEnterListener(this));
		txtInput.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		this.todoListComposite = parent;
	}

	@Focus
	public void setFocus() {
	}

	public TodoList getToDoList() {
		return todoList;
	}

	public Text getTxtInput() {
		return txtInput;
	}

	public void renderNewTodo() {
		String todo = txtInput.getText();
		if (txtInput.getText() == "" || txtInput.getText() == null) {
			return;
		}
		Composite elementRowLayout = new Composite(todoListComposite, SWT.BORDER);
		elementRowLayout.setLayout(new GridLayout(4, false));
		elementRowLayout.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(elementRowLayout, SWT.NONE);
		label.setText(todo);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button btnDelete = new Button(elementRowLayout, SWT.NONE);
		btnDelete.setImage(IconHandler.getIcon("delete"));
		btnDelete.addSelectionListener(new TodoDeleteListener(this));

		Button btnUp = new Button(elementRowLayout, SWT.NONE);
		btnUp.setImage(IconHandler.getIcon("up"));
		btnUp.addSelectionListener(new TodoMoveUpListener(this));

		Button btnDown = new Button(elementRowLayout, SWT.NONE);
		btnDown.setImage(IconHandler.getIcon("down"));
		btnDown.addSelectionListener(new TodoMoveDownListener(this));

		///SetData for button so that it can easily check selected element
		Todo elementData = handleAddTodo(elementRowLayout);
		btnDelete.setData(elementData);
		btnUp.setData(elementData);
		btnDown.setData(elementData);
		
		this.refreshLayout();
	}

	public Todo handleAddTodo(Composite composite) {
		return todoList.add(txtInput.getText(), composite);
	}

	public void refreshLayout() {
		todoListComposite.requestLayout();
	}

}