package com.kmstechnology.todolist.app.handlers;

import com.kmstechnology.todolist.app.parts.TodoAppPart;

public class PartRefresher {
	private static TodoAppPart todoAppPart;
	public static void refresh(){
		todoAppPart.setFocus();
	}
	
	public static void setTodoAppPart(TodoAppPart todoAppPart){
		PartRefresher.todoAppPart = todoAppPart;
	}
}
