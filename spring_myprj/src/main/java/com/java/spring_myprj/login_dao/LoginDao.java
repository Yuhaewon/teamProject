package com.java.spring_myprj.login_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LoginDao {
	DataSource datasource;
	
	public LoginDao() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/orcl");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
//회원가입부분
	public void join(String userId, String securityPw, String eMail, String userGender, String userIden, String userAddr,
			String userPwhint, String userJoin, String userInterests, String userNum, String userNick, String userName, String userPwCheck, String userPhone,String userPwhintList) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=datasource.getConnection();
			String sql="insert into users(" + 
					"userid,userpw,eMail,usergender,useriden,useraddr," + 
					"userpwhint,userjoin,userinterests,usernum,usernick,"+
					"userName,userPwCheck,userPhone,userPwhintList)" + 
					"values(" + 
					"?,?,?,?,?,?,?,sysdate,?,users_seq.nextval,?,?,?,?,?)";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, securityPw);
			pstmt.setString(3, eMail);
			pstmt.setString(4, userGender);
			pstmt.setString(5, userIden);
			pstmt.setString(6, userAddr);
			pstmt.setString(7, userPwhint);
			pstmt.setString(8, userInterests);
			pstmt.setString(9, userNick);
			pstmt.setString(10, userName);
			pstmt.setString(11, userPwCheck);
			pstmt.setString(12, userPhone);
			pstmt.setString(13, userPwhintList);
			
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
//로그인
	public boolean login(String userId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean check=false;
		int checkNum = 0;
		try {
			conn=datasource.getConnection();
			String sql="select count(userid)userid from users where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				checkNum=rs.getInt("userid");
			}
			System.out.println("checkNum1 : "+checkNum);
			if (checkNum>=1) {
				check=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	
	//마스터 아이디 체크
	public boolean master_login(String masterId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean check=false;
		int checkNum = 0;
		try {
			conn=datasource.getConnection();
			String sql="select count(masterId)masterId from master where masterId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, masterId);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				checkNum=rs.getInt("masterId");
			}
			System.out.println("checkNum2 : "+checkNum);
			if (checkNum>=1) {
				check=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	
//아이디 비밀번호 일치 체크
	public String loginCheck(String userId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String checkPw="";
		
		try {
			conn=datasource.getConnection();
			String sql= "select userpw from users where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				checkPw=rs.getString("userpw");
			}
			System.out.println("checkPw1 : "+checkPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return checkPw;
	}
	
	//마스터 아이디 비밀번호 일치 췌에엑!!!!
	public String master_loginCheck(String masterId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String checkPw="";
		
		try {
			conn=datasource.getConnection();
			String sql= "select masterPw from master where masterId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, masterId);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				checkPw=rs.getString("masterPw");
			}
			System.out.println("checkPw2 : "+checkPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return checkPw;
	}

	public String findId(String findName, String findbirth) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String findId="";
		try {
			conn=datasource.getConnection();
			String sql="select userid from users where userName=? and useriden=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, findName);
			pstmt.setString(2, findbirth);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				findId=rs.getString("userid");
			}
			
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
		System.out.println("findName : "+findName);
		System.out.println("findId : "+findId);
		return findId;
	}
	
	public String findPw(String checkPwhintList, String checkPwhint, String checkId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int chicking=0;
		String temporaryPw = "";
		
		try {
			conn=datasource.getConnection();
		String sql="select count(userid)userid from users "
				+ "where userid=? and userPwhintlist=? and userPwhint=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, checkId);
		pstmt.setString(2, checkPwhintList);
		pstmt.setString(3, checkPwhint);
		rs=pstmt.executeQuery();
		while(rs.next()){
			chicking=rs.getInt("userid");
		}
		if (chicking>0) {
			System.out.println("makeTemporaryPw(checkId) : "+makeTemporaryPw(checkId));
			temporaryPw=makeTemporaryPw(checkId);
		}
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
				if (rs!=null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return temporaryPw;
	}

	//힌트체크
	public String hint_check(String checkId, String checkPwhintList) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String userPwhint = "";
		
		try {
			conn=datasource.getConnection();
			String sql="select userPwhint from users where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				userPwhint=rs.getString("userPwhint");
			}
			System.out.println("checkHint : "+userPwhint);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return userPwhint;
	}
	
	
	private String makeTemporaryPw(String checkId) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Random ran=new Random();
		String tpw=(int)ran.nextInt(100000)+"";
		
		System.out.println("tpw : "+tpw);
		String encoddtpw= passwordEncoder.encode(tpw);
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=datasource.getConnection();
			String sql="update users set userPw=? where userId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, encoddtpw);
			pstmt.setString(2, checkId);
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
		return tpw;
	}
}