package com.himedia.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.shop.dto.AddressVO;
import com.himedia.shop.dto.MemberVO;
import com.himedia.shop.util.Db;

public class MemberDao {

	private MemberDao() {
	}

	private static MemberDao itc = new MemberDao();

	public static MemberDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberVO getMember(String userid) {
		MemberVO mvo = null;
		con = Db.getConnection();
		String sql = "select * from member where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mvo = new MemberVO();
				mvo.setUserid(rs.getString("userid"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setZip_num(rs.getString("zip_num"));
				mvo.setAddress1(rs.getString("address1"));
				mvo.setAddress2(rs.getString("address2"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setUseyn(rs.getString("useyn"));
				mvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.close(con, pstmt, rs);
		}
		return mvo;
	}

	public ArrayList<AddressVO> selectAddressByDong(String dong) {
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		con = Db.getConnection();
		String sql = "select * from address where dong like concat('%', ?, '%') ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setZip_num(rs.getString("zip_num"));
				avo.setSido(rs.getString("sido"));
				avo.setGugun(rs.getString("gugun"));
				avo.setDong(rs.getString("dong"));
				avo.setZip_code(rs.getString("zip_code"));
				avo.setBunji(rs.getString("bunji"));
				list.add(avo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.close(con, pstmt, rs);
		}
		return list;
	}

	public int insertMember(MemberVO mvo) {
		int result = 0;
		String sql = "insert into member(userid, pwd, name, zip_num, address1, address2, email, phone)  "
				+ " values( ?, ?, ?, ?, ?, ?, ?, ? )";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getUserid());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getZip_num());
			pstmt.setString(5, mvo.getAddress1());
			pstmt.setString(6, mvo.getAddress2());
			pstmt.setString(7, mvo.getEmail());
			pstmt.setString(8, mvo.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.close(con, pstmt, rs);
		}
		return result;
	}

	public void updateMember(MemberVO mvo) {
		con = Db.getConnection();
		String sql = "UPDATE member SET  pwd=?,name=?,zip_num=?,address1=?,address2=?,email=?,phone=? WHERE userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getZip_num());
			pstmt.setString(4, mvo.getAddress1());
			pstmt.setString(5, mvo.getAddress2());
			pstmt.setString(6, mvo.getEmail());
			pstmt.setString(7, mvo.getPhone());
			pstmt.setString(8, mvo.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.close(con, pstmt, rs);
		}
	}

	public void deleteMember(String userid) {
		con = Db.getConnection();
		String sql = "UPDATE member SET useyn='N' WHERE userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.close(con, pstmt, rs);
		}
	}
}
