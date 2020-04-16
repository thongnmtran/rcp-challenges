package com.kmstechnology.todolist.app.parts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.kmstechnology.todolist.app.handlers.TodoEnterListener;
import com.kmstechnology.todolist.core.model.Todo;

public class TodoAppPart {

	private Text txtInput;
	private List<Todo> todoList = new ArrayList<Todo>();
	private Composite parent;

	public List<Todo> getTodoList() {
		return todoList;
	}

	public void addTodo(String todo) {
		todoList.add(new Todo(todo));
	}

	public void handleAddTodo(String todo) {
		addTodo(todo);
		refreshTodoList(todo);
		txtInput.setText("");
	}

	private TableViewer tableViewer;

	@Inject
	private MDirtyable dirty;

	@PostConstruct
	public void createComposite(Composite parent) {
		this.parent = parent;
		parent.setLayout(new GridLayout(1, false));
		txtInput = new Text(parent, SWT.BORDER);
		txtInput.setMessage("Enter new todo...");
		// txtInput.addModifyListener(new ModifyListener() {
		// @Override
		// public void modifyText(ModifyEvent e) {
		// dirty.setDirty(true);
		// }
		// });

		txtInput.addKeyListener(new TodoEnterListener(txtInput, this));
		txtInput.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		for (Todo todo : todoList) {
			Composite elementRowLayout = new Composite(parent, SWT.BORDER);
			elementRowLayout.setLayout(new GridLayout(2, false));
			elementRowLayout.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			Label label = new Label(elementRowLayout, SWT.NONE);
			label.setText(todo.getText());
			label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			Button button = new Button(elementRowLayout, SWT.NONE);
			button.setText("Delete");
		}

		// tableViewer = new TableViewer(parent, SWT.V_SCROLL);
		//
		// tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		// tableViewer.setInput(createInitialDataModel(parent));
		// tableViewer.getTable().setLayoutData(new
		// GridData(GridData.FILL_BOTH));
	}

	@Focus
	public void setFocus() {
		// for (Todo todo : todoList) {
		// Composite elementRowLayout = new Composite(parent, SWT.BORDER);
		// elementRowLayout.setLayout(new GridLayout(2, false));
		// elementRowLayout.setLayoutData(new
		// GridData(GridData.FILL_HORIZONTAL));
		// Label label = new Label(elementRowLayout, SWT.NONE);
		// label.setText(todo.getText());
		// label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// Button button = new Button(elementRowLayout, SWT.NONE);
		// button.setText("Delete");
		// }
	}

	public void refreshTodoList(String todo) {
		if (parent.getChildren().length > 1 && parent.getChildren()[1] != null
				&& !parent.getChildren()[1].isDisposed()) {
			parent.getChildren()[1].dispose();
		}

		Composite elementRowLayout = new Composite(parent, SWT.BORDER);
		elementRowLayout.setLayout(new GridLayout(2, false));
		elementRowLayout.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(elementRowLayout, SWT.NONE);
		label.setText(todo);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button button = new Button(elementRowLayout, SWT.NONE);
		button.setText("Delete");

		parent.layout(true, true);
//		parent.requestLayout();
//		parent.pack();
	}
}