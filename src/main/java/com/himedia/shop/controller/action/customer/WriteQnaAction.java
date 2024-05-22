package com.himedia.shop.controller.action.customer;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.QnaDao;
import com.himedia.shop.dto.QnaVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteQnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 내용을 레코드에 추가하고 qnaList로 되돌아갑니다
		QnaDao qdao = QnaDao.getInstance();
		QnaVO qvo = new QnaVO();
		qvo.setUserid(request.getParameter("userid"));
		qvo.setSubject(request.getParameter("subject"));
		qvo.setContent(request.getParameter("content"));
		qdao.insertQna(qvo);
		
		
		response.sendRedirect("shop.do?command=qnaList");
	}

}
