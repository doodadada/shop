package com.himedia.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.shop.dto.QnaVO;
import com.himedia.shop.util.Db;
import com.himedia.shop.util.Paging;

public class QnaDao {
	private QnaDao() {
	}

	private static QnaDao itc = new QnaDao();

	public static QnaDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<QnaVO> selectQna(Paging paging) {
		con = Db.getConnection();
		String sql = "SELECT * FROM qna ORDER BY qseq DESC LIMIT ? OFFSET ?";
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getDisplayRow());
			pstmt.setInt(2, paging.getStartNum()-1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setUserid(rs.getString("userid"));
				qvo.setReply(rs.getString("reply"));
				qvo.setIndate(rs.getTimestamp("indate"));
//				System.out.println(qvo.toString());
				list.add(qvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.close(con, pstmt, rs);
		}
		return list;
	}

	public QnaVO getQna(int qseq) {
		con = Db.getConnection();
		String sql = "SELECT * FROM qna WHERE qseq=?";
		QnaVO qvo = new QnaVO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setUserid(rs.getString("userid"));
				qvo.setReply(rs.getString("reply"));
				qvo.setIndate(rs.getTimestamp("indate"));
//				System.out.println(qvo.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.close(con, pstmt, rs);
		}
		return qvo;
	}

	public void insertQna(QnaVO qvo) {
		con = Db.getConnection();
		String sql = "INSERT INTO qna(subject, content, userid) VALUES(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getSubject());
			pstmt.setString(2, qvo.getContent());
			pstmt.setString(3, qvo.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.close(con, pstmt, rs);
		}
	}

	public int getAllCount() {
		int count = 0;
		con = Db.getConnection();
		String sql = "SELECT COUNT(*) AS cnt FROM qna";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count=rs.getInt("cnt");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.close(con, pstmt, rs);
		}
		return count;
	}
}


