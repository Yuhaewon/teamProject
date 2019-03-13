package com.java.spring_myprj.favideo.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.java.spring_myprj.favideo.dto.vDto;
import com.java.spring_myprj.favideo.util.Constant;

public class vDao {

	DataSource dataSource;
	JdbcTemplate template = null;
	
	public vDao() {
		template=Constant.template;
	}


	public ArrayList<vDto> list(int rowStart, int rowEnd) {
		ArrayList<vDto> dtos = null;
		String sql = "SELECT USERID, VDATE, VNUM, VTITLE, VCONTENT, VIMAGE"
				+ " FROM (" + "SELECT USERID, VDATE, VNUM, VTITLE, VCONTENT, VIMAGE,"
				+ " ROW_NUMBER() OVER(ORDER BY VDATE DESC, VDATE ASC) FAVIDEO_SEQ FROM FAVIDEO)"
				+ " WHERE FAVIDEO_SEQ BETWEEN " + rowStart + " AND " + rowEnd;
		
		dtos = (ArrayList<vDto>) template.query(sql, new BeanPropertyRowMapper<vDto>(vDto.class));

		return dtos;
	}

	public int selectBoard2Count() {
		String query = "select count(*) from faVideo";
		int total = template.queryForObject(query, Integer.class);
		return total;
	}

}
