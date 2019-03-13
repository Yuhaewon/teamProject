package com.java.spring_myprj.uwwritedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.java.spring_myprj.dto.VideoDto;
import com.java.spring_myprj.uwutil.Constant;

public class Dao {

	DataSource dataSource;

	JdbcTemplate template = null;

	public Dao() {
		template = Constant.template;
	}

	// 게시판 리스트 화면
	public ArrayList<VideoDto> list(int rowStart, int rowEnd) {

		ArrayList<VideoDto> dtos = null;

		String sql = "SELECT vNum, userId, vTitle, vContent, vDate, vHit, vaddr" + " FROM ("
				+ "SELECT vNum, userId, vTitle, vContent, vDate, vHit, vaddr,"
				+ " ROW_NUMBER() OVER(ORDER BY VDATE DESC, VDATE ASC) VNUM_SEQ FROM VIDEO)"
				+ " WHERE VNUM_SEQ BETWEEN " + rowStart + " AND " + rowEnd;

		dtos = (ArrayList<VideoDto>) template.query(sql, new BeanPropertyRowMapper<VideoDto>(VideoDto.class));

		return dtos;
	}

	// 작성
	public void write(final String vTitle, final String vContent, final String userId, final String wFile,final String pFile, final String userInterests) {

		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into VIDEO(vNum,userId,vTitle,vHit,vContent,vAddr,vImage,userInterests)"
						+ "values(VNUM_SEQ.nextval,?,?,0,?,?,?,?)";

				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setString(1, userId);
				pstmt.setString(2, vTitle);
				pstmt.setString(3, wFile);
				pstmt.setString(4, vContent);
				pstmt.setString(5, pFile);
				pstmt.setString(6, userInterests);
				
				return pstmt;

			}
		});
	}

	// 삭제
	public void delete(final String vNum) {
		fadelete(vNum);
		String sql = "delete from VIDEO where vNum=?";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vNum);
			}
		});
	}

	private void fadelete(final String vNumfa) {
		String sql = "delete from favideo where vNum=? ";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vNumfa);
			}
		});
	}

	// 자세히보기
	public VideoDto contentView(String strvNum) {
		upHit(strvNum);
		String sql = "select * from VIDEO where vNum=" + strvNum;

		VideoDto dto = null;
		dto = template.queryForObject(sql, new BeanPropertyRowMapper<VideoDto>(VideoDto.class));

		return dto;

	}

	// 조회수
	private void upHit(final String strvNum) {

		String sql = "update VIDEO set vHit = vHit + 1 where vNum = " + strvNum;

		template.update(sql);
	}

	// 수정
	public void modify(final String vNum, final String userNick, final String vTitle, final String wFile,
			final String vContent) {

		String sql = "update VIDEO set vTitle=?,vContent=?,vaddr=? where vNum=?";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setString(1, vTitle);
				ps.setString(2, vContent);
				ps.setString(3, wFile);
				ps.setInt(4, Integer.parseInt(vNum));

			}
		});
	}

	// 페이징
	public int selectBoard1Count() {
		String query = "select count(*) from VIDEO";
		int total = template.queryForObject(query, Integer.class);
		return total;
	}

}
