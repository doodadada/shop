package com.himedia.shop.controller.action.mypage;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.MemberDao;
import com.himedia.shop.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		if (mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		}else {
			MemberDao mdao = MemberDao.getInstance();
			// 해당 회원의 useyn을 N으로 바꿔주세요
			mdao.deleteMember(mvo.getUserid());
			
			session.removeAttribute("loginUser");
			
			session.setAttribute("message", "회원탈퇴가 완료되었습니다");
			response.sendRedirect("shop.do?command=loginForm");
		}
	}

}
