package com.himedia.shop.controller.action.mypage;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.OrderDao;
import com.himedia.shop.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderInsertOneAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo ==null)
			response.sendRedirect("shop.do?command=loginForm");
		else {
			OrderDao odao  = OrderDao.getInstance();
			odao.insertOrders(mvo.getUserid());
			int oseq = odao.lookupMaxOseq(mvo.getUserid());
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int pseq = Integer.parseInt(request.getParameter("pseq"));
			//System.out.println(oseq+"/"+quantity);
			odao.insertOrderOne(oseq, quantity, pseq);
			response.sendRedirect("shop.do?command=orderList&oseq="+oseq);
		}
	}

}
