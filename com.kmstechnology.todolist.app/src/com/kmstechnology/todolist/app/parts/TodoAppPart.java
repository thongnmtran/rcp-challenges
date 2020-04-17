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
//		for (Todo todo : todoList.get()) {
//			Composite elementRowLayout = new Composite(todoListComposite, SWT.BORDER);
//			elementRowLayout.setLayout(new GridLayout(2, false));
//			elementRowLayout.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//			Label label = new Label(elementRowLayout, SWT.NONE);
//			label.setText(todo.getText());
//			label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//			Button button = new Button(elementRowLayout, SWT.NONE);
//			button.setText("Delete");
//		}

		// tableViewer = new TableViewer(parent, SWT.V_SCROLL);
		//
		// tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		// tableViewer.setInput(createInitialDataModel(parent));
		// tableViewer.getTable().setLayoutData(new
		// GridData(GridData.FILL_BOTH));
	}

	@Focus
	public void setFocus() {
	}

	public Text getTxtInput() {
		return txtInput;
	}

	public void renderNewTodo() {
		String todo = txtInput.getText();
//		if (parent.getChildren().length > 1 && parent.getChildren()[1] != null
//				&& !parent.getChildren()[1].isDisposed()) {
//			parent.getChildren()[1].dispose();
//		}

		Composite elementRowLayout = new Composite(todoListComposite, SWT.BORDER);
		elementRowLayout.setLayout(new GridLayout(2, false));
		elementRowLayout.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(elementRowLayout, SWT.NONE);
		label.setText(todo);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button button = new Button(elementRowLayout, SWT.NONE);
		button.setText("Delete");
		button.addSelectionListener(new TodoDeleteListener(this));
		
		Todo elementData = handleAddTodo(elementRowLayout);
		button.setData(elementData);
		this.refreshLayout();
//		parent.layout(true, true);
//		parent.pack();
	}
	
	public void refreshLayout(){
		todoListComposite.requestLayout();
	}
	
	public Todo handleAddTodo(Composite composite) {
		return todoList.add(txtInput.getText(), composite);
	}
}