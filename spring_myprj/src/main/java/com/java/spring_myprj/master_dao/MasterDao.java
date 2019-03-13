package com.java.spring_myprj.master_dao;

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

import com.java.spring_myprj.dto.VideoDto;
import com.java.spring_myprj.dto.review.ReviewDto;
import com.java.spring_myprj.login_dto.LoginDto;

public class MasterDao {
	DataSource datasource;

	public MasterDao() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/orcl");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void nickModify(String userNick, String userNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = datasource.getConnection();
			String sql = "update users set userNick=? where usernum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userNick);
			pstmt.setString(2, userNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<LoginDto> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LoginDto> dtos = new ArrayList<LoginDto>();
		try {
			conn = datasource.getConnection();
			String sql = "select * from users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("userId");
				String userPw = rs.getString("userPw");
				String eMail = rs.getString("eMail");
				String userGender = rs.getString("userGender");
				String userIden = rs.getString("userIden");
				String userAddr = rs.getString("userAddr");
				String userPwhint = rs.getString("userPwhint");
				Timestamp userJoin = rs.getTimestamp("userJoin");
				String userInterests = rs.getString("userInterests");
				int userNum = rs.getInt("userNum");
				String userNick = rs.getString("userNick");
				String userName = rs.getString("userName");
				String userPwCheck = rs.getString("userPwCheck");
				String userPhone = rs.getString("userPhone");
				String userpWhintList = rs.getString("userpWhintList");
				LoginDto dto = new LoginDto(userId, userPw, eMail, userGender, userIden, userAddr, userPwhint, userJoin,
						userInterests, userNum, userNick, userName, userPwCheck, userPhone, userpWhintList);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public LoginDto choiceUser(String choiceUserNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginDto dto = new LoginDto();

		try {
			conn = datasource.getConnection();
			String sql = "select * from users where userId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, choiceUserNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("userId");
				String userPw = rs.getString("userPw");
				String eMail = rs.getString("eMail");
				String userGender = rs.getString("userGender");
				String userIden = rs.getString("userIden");
				String userAddr = rs.getString("userAddr");
				String userPwhint = rs.getString("userPwhint");
				Timestamp userJoin = rs.getTimestamp("userJoin");
				String userInterests = rs.getString("userInterests");
				int userNum = rs.getInt("userNum");
				String userNick = rs.getString("userNick");
				String userName = rs.getString("userName");
				String userPwCheck = rs.getString("userPwCheck");
				String userPhone = rs.getString("userPhone");
				String userpWhintList = rs.getString("userpWhintList");
				dto = new LoginDto(userId, userPw, eMail, userGender, userIden, userAddr, userPwhint, userJoin,
						userInterests, userNum, userNick, userName, userPwCheck, userPhone, userpWhintList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public void userDelete(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = datasource.getConnection();
			String sql = "delete from users where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<LoginDto> serchUser(String sUser) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LoginDto> dtos = new ArrayList<LoginDto>();
		LoginDto dto = new LoginDto();
		try {
			conn = datasource.getConnection();
			String sql = "select * from users where (userId || userName) like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sUser + "%");
			rs = pstmt.executeQuery(); // 결과 값을 rs에 저장
			while (rs.next()) {
				System.out.println("혜원이 화났으니까 얼른 여기까지 와라");
				String userId = rs.getString("userId");
				String userPw = rs.getString("userPw");
				String eMail = rs.getString("eMail");
				String userGender = rs.getString("userGender");
				String userIden = rs.getString("userIden");
				String userAddr = rs.getString("userAddr");
				String userPwhint = rs.getString("userPwhint");
				Timestamp userJoin = rs.getTimestamp("userJoin");
				String userInterests = rs.getString("userInterests");
				int userNum = rs.getInt("userNum");
				String userNick = rs.getString("userNick");
				String userName = rs.getString("userName");
				String userPwCheck = rs.getString("userPwCheck");
				String userPhone = rs.getString("userPhone");
				String userpWhintList = rs.getString("userpWhintList");
				dto = new LoginDto(userId, userPw, eMail, userGender, userIden, userAddr, userPwhint, userJoin,
						userInterests, userNum, userNick, userName, userPwCheck, userPhone, userpWhintList);
				dtos.add(dto);
				System.out.println("dto : " + dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("dtos :" + dtos);
		return dtos;
	}

	public ArrayList<VideoDto> mUserVideo(String choiceUserId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<VideoDto> dtos = new ArrayList<VideoDto>();
		VideoDto dto = new VideoDto();

		try {
			conn = datasource.getConnection();
			String sql = "select * from video where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, choiceUserId);
			rs = pstmt.executeQuery(); // 결과 값을 rs에 저장
			while (rs.next()) {
				int vNum = rs.getInt("vNum");
				int vHit = rs.getInt("vHit");
				Timestamp vDate = rs.getTimestamp("vDate");
				String userId = rs.getString("userId");
				String vAddr = rs.getString("vAddr");
				String vTitle = rs.getString("vTitle");
				String vContent = rs.getString("vContent");
				String userInterests = rs.getString("userInterests");
				String vReview = rs.getString("vReview");
				String vImage = rs.getString("vImage");
				dto = new VideoDto(vNum, vHit, vDate, userId, vAddr, vTitle, vContent, userInterests, vReview, vImage);
				dtos.add(dto);
				System.out.println("dto : " + dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public ArrayList<ReviewDto> mUserComment(String choiceUserId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReviewDto> dtos = new ArrayList<ReviewDto>();
		ReviewDto dto = new ReviewDto();

		try {
			conn = datasource.getConnection();
			String sql = "select * from review where userId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, choiceUserId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int rNum = rs.getInt("rNum");
				int vNum = rs.getInt("vNum");
				String userId = rs.getString("userId");
				String userNick = rs.getString("userNick");
				String rContent = rs.getString("rContent");
				Timestamp rDate = rs.getTimestamp("rDate");
				dto = new ReviewDto(rNum, userNick, rContent, rDate, vNum, userId);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public void videoDelete(String vNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = datasource.getConnection();
			String sql = "delete from video where vNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void commentDelete(String rNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = datasource.getConnection();
			String sql = "delete from review where rNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<LoginDto> chartJoinUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LoginDto> dtos = new ArrayList<LoginDto>();
		LoginDto dto = new LoginDto();
		try {
			conn = datasource.getConnection();
			String sql = "select T2.yyyymm, nvl(T1.count, 0) count" + 
					" from (select to_char(userjoin, 'yyyymm') yyyymm, count(userNum) count" + 
					" from users" + 
					" group by to_char(userjoin, 'yyyymm')) T1," + 
					" (select '2019'||lpad(level, 2, '0') yyyymm" + 
					" from dual" + 
					" connect by level <= 12) T2" + 
					" where T1.yyyymm(+)=T2.yyyymm" + 
					" order by 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 결과 값을 rs에 저장
			while (rs.next()) {
				int count=rs.getInt("count");
				dto = new LoginDto(count);
				dtos.add(dto);
				System.out.println("dto : " + dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("dtos :" + dtos);
		return dtos;
	}
}
