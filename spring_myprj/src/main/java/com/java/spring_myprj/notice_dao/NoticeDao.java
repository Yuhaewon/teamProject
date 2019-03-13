package com.java.spring_myprj.notice_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.java.spring_myprj.notice_dto.NoticeDto;

public class NoticeDao {
	DataSource datasource;
	
	
//공지게시판부분
	public NoticeDao() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/orcl");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<NoticeDto> list() {
		ArrayList<NoticeDto> dtos = new ArrayList<NoticeDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = datasource.getConnection();
			String sql = "select master,mnum,mdate,mtitle,mcontent,mhit,mfile"
			+ " from mnotice order by mnum desc";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String master = rs.getString("master");
				int mNum = rs.getInt("mNum");
				Timestamp mDate = rs.getTimestamp("mDate");
				String mTitle = rs.getString("mTitle");
				String mContent = rs.getString("mContent");
				int mHit = rs.getInt("mHit");
				String mFile = rs.getString("mFile");

				NoticeDto dto = new NoticeDto(master, mNum, mDate, mTitle, mContent, mHit, mFile);

				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public NoticeDto contentView(String strMaster) {
		upHit(strMaster);
		
		NoticeDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=datasource.getConnection();
			String sql="select * from mnotice where master=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, strMaster);
			
			rs=pstmt.executeQuery();
			if (rs.next()) {
				String master=rs.getString("master");
				int mNum=rs.getInt("mNum");
				Timestamp mDate=rs.getTimestamp("mDate");
				String mTitle=rs.getString("mTitle");
				String mContent=rs.getString("mContent");
				int mHit=rs.getInt("mHit");
				String mFile=rs.getString("mFile");
				
				dto=new NoticeDto(master,mNum,mDate,mTitle,mContent,mHit,mFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	private void upHit(String strMaster) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = datasource.getConnection();
			String sql = "update mnotice set mhit=mhit+1 where master=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strMaster);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void write(String master, String mTitle, String mContent) {
		System.out.println("들어와라 : "+master+","+mTitle+","+mContent);
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=datasource.getConnection();
			String sql="insert into mNotice(master,mnum,mtitle,mcontent,mhit,mdate)"
			+ "values(?,mnotice_seq.nextval,?,?,0,sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, master);
			pstmt.setString(2, mTitle);
			pstmt.setString(3, mContent);
			pstmt.executeUpdate();
			System.out.println("들어와라2 : "+master+","+mTitle+","+mContent);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(String mNum) {
		System.out.println("delete : "+mNum);
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=datasource.getConnection();
			String sql="delete from mNotice where mNum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(mNum));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void modify(String mNum, String mTitle, String mContent, String master) {
		System.out.println("passing modify dao");
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=datasource.getConnection();
			String sql="update mnotice set master=?, mtitle=?,mcontent=? where mNum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, master);
			pstmt.setString(2, mTitle);
			pstmt.setString(3, mContent);
			pstmt.setInt(4, Integer.parseInt(mNum));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null) {
					conn.close();
				}
				if (pstmt!=null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}