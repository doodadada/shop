package com.himedia.shop.controller.action.customer;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.QnaDao;
import com.himedia.shop.dto.MemberVO;
import com.himedia.shop.dto.QnaVO;
import com.himedia.shop.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		if (mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		}else {
			QnaDao qdao = QnaDao.getInstance();
			int page = 1;
			Paging paging = new Paging();
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if(session.getAttribute("page")!=null) {
				page=(Integer)session.getAttribute("page");
			}
//			else {
//				session.removeAttribute("page");
//			}
			paging.setPage(page); // 결정된 page값을 객체의 해당 멤버변수에 저장합니다.
			paging.setDisplayRow(5);
			paging.setDisplayPage(5);
			// 1. 페이지 구성요소들을 계산하기 위해 총 레코드 갯수부터 조회
			int count = qdao.getAllCount();
			System.out.println("레코드 갯수 : "+count);
			
			// 2. 조회한 레코드갯수를 Paging 객체의 totalCount에 입력(setTotalCount()이용)
			paging.setTotalCount(count); // 이때 calPaging()이 호출되서 모든 멤버변수가 계산됩니다.
			
			// 3. Paging 객체의 startNum(시작 레코드 번호)부터 displayRow(한 화면당 레코드 갯수)만큼 조회합니다
			ArrayList<QnaVO> list =qdao.selectQna(paging);
			
			//--------------------
			request.setAttribute("qnaList", list);
			request.setAttribute("paging", paging);
			request.getRequestDispatcher("customer/qnaList.jsp").forward(request,response);
		}
	}

}
