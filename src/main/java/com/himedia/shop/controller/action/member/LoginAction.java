package com.himedia.shop.controller.action.member;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.MemberDao;
import com.himedia.shop.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		
		MemberDao mdao=MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(userid);
		
		if(mvo ==null) {
			
		}else if(!mvo.getPwd().equals(pwd)) {
			
		}else if(mvo.getPwd().equals(pwd)) {
			
		}
	}

}
