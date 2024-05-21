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
import com.himedia.shop.controller.action.mypage.CartDeleteAction;
import com.himedia.shop.controller.action.mypage.CartInsertAction;
import com.himedia.shop.controller.action.mypage.CartListAction;
import com.himedia.shop.controller.action.mypage.OrderInsertAction;
import com.himedia.shop.controller.action.mypage.OrderInsertOneAction;
import com.himedia.shop.controller.action.mypage.OrderListAction;
import com.himedia.shop.controller.action.product.CategoryAction;
import com.himedia.shop.controller.action.product.ProductDetailAction;

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
		//product
		else if( command.equals("category") ) ac = new CategoryAction();
		else if( command.equals("productDetail") ) ac = new ProductDetailAction();
		//mypage
		else if( command.equals("cartInsert") ) ac = new CartInsertAction();
		else if( command.equals("cartList") ) ac = new CartListAction();
		else if( command.equals("cartDelete") ) ac = new CartDeleteAction();
		else if( command.equals("orderInsert") ) ac = new OrderInsertAction();
		else if( command.equals("orderList") ) ac = new OrderListAction();
		else if( command.equals("orderInsertOne") ) ac = new OrderInsertOneAction();
		
		
		return ac;
	}
	
	
}






