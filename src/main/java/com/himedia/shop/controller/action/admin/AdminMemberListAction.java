package com.himedia.shop.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.AdminDao;
import com.himedia.shop.dto.AdminVO;
import com.himedia.shop.dto.MemberVO;
import com.himedia.shop.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO) session.getAttribute("adminUser");

		if (avo == null) {
			response.sendRedirect("shop.do?command=admin");
		}else {
			Paging paging = new Paging();
			if(request.getParameter("page")!=null) {
				paging.setPage(Integer.parseInt(request.getParameter("page")));
				session.setAttribute("page", Integer.parseInt(request.getParameter("page")));
			}else if(session.getAttribute("page")!=null) {
				paging.setPage((Integer)session.getAttribute("page"));
			}else {
				paging.setPage(1);
				session.removeAttribute("page");
			}
			String key="";
			if(request.getParameter("key")!=null) {
				key=request.getParameter("key");
				session.setAttribute("key",key);
			}else if(session.getAttribute("key") !=null) {
				key = (String)session.getAttribute("key");
			}else {
				session.removeAttribute("key");
			}
			AdminDao adao = AdminDao.getInstance();
			int count = adao.getAllCount("member","name",key);
			paging.setTotalCount(count);
			ArrayList<MemberVO> memberList = adao.adminMemberList(paging,key);
			request.setAttribute("paging", paging);
			request.setAttribute("memberList", memberList);
			request.setAttribute("key", key);
		}
		
		request.getRequestDispatcher("admin/member/memberList.jsp").forward(request, response);
	}

}
