package com.himedia.shop.controller;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.controller.action.IndexAction;
import com.himedia.shop.controller.action.member.LoginFormAction;

public class ActionFactory {

	private ActionFactory() {
	}

	private static ActionFactory itc = new ActionFactory();

	public static ActionFactory getInstance() {
		return itc;
	}

	public Action getAction(String command) {
		Action ac = null;
		if(command.equals("index")) ac = new IndexAction();
		
		//member
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		
		return ac;
	}
}
