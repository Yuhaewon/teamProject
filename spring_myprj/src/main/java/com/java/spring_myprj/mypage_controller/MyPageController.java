package com.java.spring_myprj.mypage_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring_myprj.dao.IDao;

import gu.common.SearchVO;

@Controller
public class MyPageController {

	
		
	@Autowired
	private SqlSession sqlSession;
	
	//마이페이지 메인(기본 유저정보 출력)
	@RequestMapping("/mypageMain")
	public String mypageMain(HttpServletRequest request, Model model) {
		System.out.println("passing myPageMain");
		IDao dao=sqlSession.getMapper(IDao.class);
		HttpSession httpSession =request.getSession(true);
		String userId=(String) httpSession.getAttribute("userId");
		System.out.println("mypageMain userId : "+userId);
		model.addAttribute("myInfo",dao.myInfo(userId));
		
		return "mypage/mypageMain";
	}
	
	//마이페이지 메인(유저 정보 변경)
		@RequestMapping("/userModify")
		public String userModify(HttpServletRequest request,Model model) {
			System.out.println("passing userModify");
			IDao dao=sqlSession.getMapper(IDao.class);
			HttpSession httpSession = request.getSession(true);
			String userId=(String) httpSession.getAttribute("userId");
			String userName=request.getParameter("userName");
			String userNick=request.getParameter("userNick");
			String userAddr=request.getParameter("userAddr");
			String userphone=request.getParameter("userphone");
			String eMail=request.getParameter("eMail");
			String userPw=request.getParameter("userPw");
			
			System.out.println("userId : "+userId);
			System.out.println("userName ; "+userName);
			
			dao.myModify(userId,userName,userNick,userAddr,userphone,eMail,userPw);
			
			return "redirect:/mypageMain";
		}
	
	
	
	//마이페이지 (유저가 작성한 글 및 영상)
		@RequestMapping("/mypageInserVideo")
		public String mypageInserVideo(HttpServletRequest request,Model model,SearchVO searchVO) {
			System.out.println("passing mypageInserVideo");
			IDao dao=sqlSession.getMapper(IDao.class);
			HttpSession httpSession =request.getSession(true);
			String userId=(String) httpSession.getAttribute("userId");
			
			int total=dao.selectBoard2Count();
			String strPage=request.getParameter("page");
				if(strPage==null) {
					strPage="1";
				}
			
			int page=Integer.parseInt(strPage);
			searchVO.setPage(page);
			searchVO.pageCalculate(total);
			
			int rowStart=searchVO.getRowStart();
			int rowEnd=searchVO.getRowEnd();
			
			model.addAttribute("uploadVideo",dao.myUploadVideo(userId,rowStart,rowEnd));
			return "mypage/mypageInserVideo";
	}
		
	
	//마이페이지 메인(유저 탈퇴)
		@RequestMapping("/myDelete")
		public String myDelete(HttpServletRequest request,Model model) {
			System.out.println("passing myDelete");
			
			IDao dao=sqlSession.getMapper(IDao.class);
			HttpSession httpSession = request.getSession(true);
			String userId=(String) httpSession.getAttribute("userId");
			
			dao.myDelete(userId);
			
			//세션연결 끊기
			httpSession.invalidate();
			
			return "redirect:/";
		}
}
