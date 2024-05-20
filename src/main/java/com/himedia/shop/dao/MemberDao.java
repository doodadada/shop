package com.himedia.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.himedia.shop.dto.MemberVO;

public class MemberDao {

	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {
		return itc;
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public MemberVO getMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
