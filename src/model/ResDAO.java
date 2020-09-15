package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;

public class ResDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	static ResDAO instance;

	public static ResDAO getInstance() {
		if (instance == null)
			instance = new ResDAO();
		return instance;
	}

	public ArrayList<ResVO> selectAll(ResVO res) {
		ArrayList<ResVO> list = new ArrayList<ResVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT no, title, content, name, tel, address, regdate" 
						+ " FROM res"
						+ " ORDER BY no";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ResVO resultVO = new ResVO();
				resultVO = new ResVO();
				resultVO.setNo(rs.getInt("no"));
				resultVO.setTitle(rs.getString("title"));
				resultVO.setContent(rs.getString("content"));
				resultVO.setName(rs.getString("name"));
				resultVO.setTel(rs.getString("tel"));
				resultVO.setAddress(rs.getString("address"));
				resultVO.setRegdate(rs.getString("regdate"));
				list.add(resultVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}

		return list;
	}

	public ResVO selectOne(ResVO res) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT NO, TITLE, CONTENT, NAME, TEL, ADDRESS, REGDATE" 
					+ " FROM RES" 
					+ " WHERE NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, res.getNo());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				res = new ResVO();
				res.setNo(rs.getInt("no"));
				res.setTitle(rs.getString("title"));
				res.setContent(rs.getString("content"));
				res.setName(rs.getString("name"));
				res.setTel(rs.getString("tel"));
				res.setAddress(rs.getString("address"));
				res.setRegdate(rs.getString("regdate"));
			} else {
				System.out.println("조회엑스");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}

		return res;
	}

	public int count(ResVO res) {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String where = " where 1=1 ";
			if (res.getTitle() != null) {
				where += " and title like '%' || ? || '%'";
			}
			String sql = "select count(*) from res" + where;
			pstmt = conn.prepareStatement(sql);
			int pos = 1;
			if (res.getTitle() != null) {
				pstmt.setString(pos++, res.getTitle());
			}
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return cnt;

	}

	public int insert(ResVO resVO) {
		int r = 0;
		try {
			// 1. DB �뿰寃�
			conn = ConnectionManager.getConnnect();
			// 2. sql 援щЦ �떎�뻾
			String sql = "insert into res (no, title, content, name, tel, address, regdate) "
					+ "values (res_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resVO.getTitle());
			pstmt.setString(2, resVO.getContent());
			pstmt.setString(3, resVO.getName());
			pstmt.setString(4, resVO.getTel());
			pstmt.setString(5, resVO.getAddress());
			r = pstmt.executeUpdate();
			// 3. 寃곌낵泥섎━
			System.out.println(r + " 嫄댁씠 泥섎━�맖");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4. �뿰寃고빐�젣(�삤�씪�겢 �꽌踰꾩뿉 �젒�냽 �븷 �닔 �엳�뒗 �꽭�뀡�닔�뒗 �젣�븳 �쟻�씠湲� �븣臾몄뿉 �뿰寃� �빐�젣瑜� �븯吏� �븡�쑝硫� �떎�쓬�뿉 �뿰寃� 紐삵븯�뒗 �긽�솴�씠 �씪�뼱 �궇�닔
			// �엳湲� �븣臾몄뿉 媛� �떎�뻾�썑 �뿰寃� �빐�젣 �븘�슂)
			ConnectionManager.close(conn);
		}
		return r;
	}

	// �닔�젙
	public void update(ResVO resVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update res set title = ?, content = ?, name= ?,"
					+ " tel=?, address=?, regdate=sysdate "
					+ " where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resVO.getTitle());
			pstmt.setString(2, resVO.getContent());
			pstmt.setString(3, resVO.getName());
			pstmt.setString(4, resVO.getTel());
			pstmt.setString(5, resVO.getAddress());
			pstmt.setInt(6, resVO.getNo());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	// �궘�젣
	public void delete(ResVO resVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE FROM RES WHERE NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resVO.getNo());
			int r = pstmt.executeUpdate();
			System.out.println(r + " 嫄댁씠 �궘�젣�맖");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	public int login (String userID, String userPassword) {
		String sql = "SELECT userPassword from user1 where userID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1;
					} else {
					return 0;
				}
			}
			return -1; //아이디가 존재하지않음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	
	public int join (ResVO resVO) {
		int s=0;
		try {
			String sql = "insert into user1 values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resVO.getUserID());
			pstmt.setString(2, resVO.getUserPassword());
			pstmt.setString(3, resVO.getUserName());
			pstmt.setString(4, resVO.getUserGender());
			pstmt.setString(5, resVO.getUserEmail());
			s = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return s;
		
	}
}
