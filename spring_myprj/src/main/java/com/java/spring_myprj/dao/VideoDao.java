//package com.java.spring_myprj.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//
//import com.java.spring_myprj.dto.VideoDto;
//import com.java.spring_myprj.dto.review.ReviewDto;
//
//public class VideoDao {
//	JdbcTemplate template;
//
//	public VideoDao() {
//	}
//
//	@Autowired
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//	}
//	
//	
//	//비디오 뷰
//	public VideoDto vView(String vNum){
//		VideoDto dto=null;
//		String sql="select vNum,vHit,vDate,userId,vAddr,vTitle,vContent,userInterests"
//				 + ",vReview,vImage from video where vNum=" +vNum;
//		
//		dto= template.queryForObject(sql, new BeanPropertyRowMapper<VideoDto>(VideoDto.class));
//		return dto;
//	}
//	
//	//비디오 댓글 뷰
//	public ArrayList<ReviewDto> vRe(String vNum){
//		ArrayList<ReviewDto> vRe=null;
//		String sql="select rNum, userNick, rContent, rDate"
//				 + " from review where"
//				 + " vNum="+vNum+"order by rnum asc";
//		
//		vRe=(ArrayList<ReviewDto>) template.query(sql, new BeanPropertyRowMapper<ReviewDto>(ReviewDto.class));
//		System.out.println("vRe : "+vRe);
//		return vRe;
//	}
//	
//	//비디오 댓글 vWrite
//	public void vWrite(final String reply,final String vNum) {
//		
//		template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
//				String sql="insert into review (rNum, userNick, rContent, vNum)"
//						+ " values (review_SEQ.nextval,'테스트닉',?,?)";
//				
//				PreparedStatement pstmt=conn.prepareStatement(sql);
//				pstmt.setString(1, reply);
//				pstmt.setString(2, vNum);
//				return pstmt;
//			}
//		});
//	}
//	
//	//비디오 댓글 수정
//	public int vrModify(final String revContent,final String rNum){
//		int result=2;
//		try{
//			String sql="update review set rContent=? where rNum=?";
//			template.update(sql, new PreparedStatementSetter() {
//				@Override
//				public void setValues(PreparedStatement pstmt) throws SQLException {
//					pstmt.setString(1, revContent);
//					pstmt.setString(2, rNum);
//					System.out.println("됨?");
//					System.out.println("수정확인"+pstmt.executeUpdate());
//				}
//			});
//			result=1;
//		}catch (Exception e) {
//			e.printStackTrace();
//			result=2;
//		}
//		
//		return result;
//	}
//	
//	//비디오 댓글 삭제
//	public void vrDelete(final String rNum){
//		String sql="delete from review where rNum=?";
//		template.update(sql, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement pstmt) throws SQLException {
//				pstmt.setString(1, rNum);
//			}
//		});
//	}
//	
//	
//	
//}
