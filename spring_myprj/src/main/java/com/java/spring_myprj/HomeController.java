package com.java.spring_myprj;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.spring_myprj.dao.IDao;
import com.java.spring_myprj.dto.VideoDto;

@Controller
public class HomeController {
	String allVNum;
	
	
	//mybatis사용
	@Autowired
	private SqlSession sqlSession;
	
	//로그인 페이지
	@RequestMapping("/loginpage")
	public String loginpage(){
		return "login/loginpage";
	}
	
	//메인페이지 동영상 리스트
	@RequestMapping("/")
	public String videolist(HttpServletRequest request, Model model){
		IDao dao=sqlSession.getMapper(IDao.class);
		model.addAttribute("vlist", dao.vList());
		model.addAttribute("vlistH",dao.vViewH());
		System.out.println("passing list");
		return "mainpage/videolist";
	}
	
	//재생목록 가져오기
	@RequestMapping("/myVList")
	@ResponseBody
	public Object myVList(HttpServletRequest request, Model model) {
		String nsrc=request.getParameter("nsrc");
		System.out.println("nsrc : "+nsrc);
		IDao dao=sqlSession.getMapper(IDao.class);
		model.addAttribute("mlist", dao.mList(nsrc));
		System.out.println(dao.mList(nsrc).get(0).getvContent());
		return dao.mList(nsrc);
	}
	
	//비디오 검색
	@RequestMapping("/serchVideo")
	public String serchVideo(HttpServletRequest request, Model model){
		IDao dao=sqlSession.getMapper(IDao.class);
		String sVideo=request.getParameter("sVideo");
		System.out.println("sVideo : "+sVideo);
		String url=null;
		ArrayList<VideoDto> dtos=dao.selectVideo(sVideo);
		if(sVideo==null || sVideo.equals("") || dtos==null || dtos.size()==0) {
			url="/errorPage/errorPage";
		}else if(!(sVideo==null || sVideo.equals(""))) {
			model.addAttribute("selectVideo", dtos);
			url="/selectpage/selectVideo";
		}
		System.out.println(dao.selectVideo(sVideo));
		System.out.println("passing select_v");
		return url; //검색 화면 뷰 (아직 안만듬)
	}
	
	
	
	
}
