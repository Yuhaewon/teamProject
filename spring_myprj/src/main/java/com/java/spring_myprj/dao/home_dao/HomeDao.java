//package com.java.spring_myprj.dao.home_dao;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import com.java.spring_myprj.dto.VideoDto;
//
//public class HomeDao {
//		JdbcTemplate template;
//
//		public HomeDao() {
//		}
//
//		@Autowired
//		public void setTemplate(JdbcTemplate template) {
//			this.template = template;
//		}
//		
//		//비디오 리스트
//		public ArrayList<VideoDto> vList(){
//			System.out.println("This is HomeDao_vList");
//			ArrayList<VideoDto> vdto=null;
//			String sql="select vNum,vHit,vDate,userId,vAddr,vTitle,vContent,userInterests"
//					+ ",vReview,vImage from video";
//			vdto=(ArrayList<VideoDto>) template.query(sql, new BeanPropertyRowMapper<VideoDto>(VideoDto.class));
//			return vdto;
//		}
//		
//		//내가 추가한 비디오 리스트
//		public ArrayList<VideoDto> mList(String nsrc){
//			System.out.println("This is HomeDao_mList");
//			ArrayList<VideoDto> mdto=null;
//			String sql="select vImage,vTitle,vContent from video where vNum="+nsrc;
//			mdto=(ArrayList<VideoDto>) template.query(sql, new BeanPropertyRowMapper<VideoDto>(VideoDto.class));
//			return mdto;
//		}
//}
