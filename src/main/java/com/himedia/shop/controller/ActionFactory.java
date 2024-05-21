package com.himedia.shop.controller;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.controller.action.IndexAction;
import com.himedia.shop.controller.action.member.ContractAction;
import com.himedia.shop.controller.action.member.FindZipnumAction;
import com.himedia.shop.controller.action.member.IdcheckFormAction;
import com.himedia.shop.controller.action.member.JoinAction;
import com.himedia.shop.controller.action.member.JoinFormAction;
import com.himedia.shop.controller.action.member.LoginAction;
import com.himedia.shop.controller.action.member.LoginFormAction;
import com.himedia.shop.controller.action.member.LogoutAction;

public class ActionFactory {

	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	public Action getAction(String command) {
		Action ac = null;
		
		if( command.equals("index") ) ac = new IndexAction();
		
		//member
		else if( command.equals("loginForm") ) ac = new LoginFormAction(); 
		else if( command.equals("login") ) ac = new LoginAction();	
		else if( command.equals("logout") ) ac = new LogoutAction();
		else if( command.equals("contract") ) ac = new ContractAction();
		else if( command.equals("joinForm") ) ac = new JoinFormAction();
		else if( command.equals("idcheckForm") ) ac = new IdcheckFormAction();
		else if( command.equals("findZipnum") ) ac = new FindZipnumAction();
		else if( command.equals("join") ) ac = new JoinAction();
		
		return ac;
	}
	
	
}






