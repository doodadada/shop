package com.himedia.shop.controller.action.admin;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.AdminDao;
import com.himedia.shop.dao.MemberDao;
import com.himedia.shop.dto.AdminVO;
import com.himedia.shop.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminloginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminid = request.getParameter("adminid");
		String pwd = request.getParameter("pwd");
		System.out.println("adminid : "+adminid);
		System.out.println("pwd : "+pwd);
		AdminDao adao = AdminDao.getInstance();
		AdminVO avo = adao.getMember(adminid);
		
		String url = "admin/adminLogin.jsp";
		if( avo == null ) 
			request.setAttribute("message", "아이디가 없습니다");
		else if( !avo.getPwd().equals(pwd) ) 
			request.setAttribute("message", "패스워드가 틀립니다");
		else if( avo.getPwd().equals(pwd) ) {
			url = "shop.do?command=adminProductList";
			HttpSession session = request.getSession();
			session.setAttribute("adminUser", avo);
		}else 
			request.setAttribute("message", "관리자에게 문의하세요");
		
		request.getRequestDispatcher(url).forward(request, response);
		 
	}

}
