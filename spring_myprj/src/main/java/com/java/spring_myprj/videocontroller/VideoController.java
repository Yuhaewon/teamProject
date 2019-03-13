package com.java.spring_myprj.videocontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.spring_myprj.dao.IDao;


@Controller
public class VideoController {
	String allVNum;
	String videoType;
	
	//mybatis사용
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/videoView")
	public String videoView(HttpServletRequest request, Model model){
		
		IDao dao=sqlSession.getMapper(IDao.class);
		String vNum=request.getParameter("vNum");//21
		String uI=request.getParameter("userInterests");//fun
		if (vNum==null) {
			vNum=allVNum;
		}
		if (uI==null) {
			uI=videoType;
		}
		upHit(vNum);//조회수

		System.out.println("videoView,videoView = "+vNum);
		System.out.println("userInterests = "+uI);
		model.addAttribute("vView",dao.vView(vNum));
		model.addAttribute("vReview",dao.vRe(vNum));//vNum을 인수로 해당동영상의 댓글만 볼수있게
		model.addAttribute("randomList",dao.ranList(uI));
		System.out.println("dao.vRe(vNum) : "+dao.vRe(vNum));
		System.out.println("passing vView");
		
		return "videoView";
	}
	
	private void upHit(String vNum) {
		IDao dao=sqlSession.getMapper(IDao.class);
		dao.upHit(vNum);
	}

	//비디오 뷰 댓글
	@RequestMapping("/rWrite")
	public String rWrite(HttpServletRequest request, Model model){
		HttpSession httpSession=request.getSession(true);
		IDao dao=sqlSession.getMapper(IDao.class);
		String userId=(String) httpSession.getAttribute("userId");
		System.out.println("rWrite userId : "+userId);
		String reply=request.getParameter("reply");	
		String vNum=request.getParameter("vNum");
		String uI=request.getParameter("userInterests");
		allVNum=vNum;
		videoType=uI;
		if (uI==null) {
			uI=videoType;
		}
		dao.vWrite(userId,reply,vNum);
		System.out.println("passing rWrite");
		return "redirect:videoView";
	}
		
	//비디오댓글 수정 뷰
	@RequestMapping("/vrModifyView")
	public String rModifyView(HttpServletRequest request, Model model){
		IDao dao=sqlSession.getMapper(IDao.class);

		String rNum=request.getParameter("rNum");
		String vNum=request.getParameter("vNum");
		String uI=request.getParameter("userInterests");
	
		System.out.println("수정확인용"+rNum);
		System.out.println("videoView = "+vNum);
		if (vNum==null) {
			vNum=allVNum;
		}
		videoType=uI;
		model.addAttribute("reNum",rNum);
		model.addAttribute("vView",dao.vView(vNum));
		model.addAttribute("vReview",dao.vRe(vNum));//vNum을 인수로 해당동영상의 댓글만 볼수있게
		System.out.println("passing vView");
		
		return "videoView";
	}
		
	//비디오 뷰 댓글 수정
	@ResponseBody
	@RequestMapping("/vrModify")
	public String vrModify(HttpServletRequest request, Model model){
		//수정후 반환값
		int resultData;
			
		IDao dao=sqlSession.getMapper(IDao.class);
		String rNum=request.getParameter("rNum");
		String vNum=request.getParameter("vNum");
		String revContent=request.getParameter("revContent");
		String uI=request.getParameter("userInterests");
		
		
		allVNum=vNum;
		videoType=uI;
		System.out.println("vrModify : "+uI);
		System.out.println("vrModify rNum:"+rNum);
		System.out.println("vrModify vNum:"+vNum);
		System.out.println("vrModify revContent:"+revContent);
			
		resultData = dao.vrModify(revContent,rNum);
		System.out.println("resultData"+resultData);
		return resultData+"";
	}
		 
	//비디오 뷰 댓글 삭제
	@RequestMapping("/vrDelete")
	public String vrDelete(HttpServletRequest request, Model model){
		IDao dao=sqlSession.getMapper(IDao.class);
		String rNum=request.getParameter("rNum");
		String vNum=request.getParameter("vNum");
		String uI=request.getParameter("userInterests");
		System.out.println("vrDelete rNum : "+rNum);
		System.out.println("vrDelete vNum : "+vNum);
		videoType=uI;
		allVNum=vNum;
		dao.vrDelete(rNum);
		System.out.println("passing vrDelete");
	
		return "redirect:videoView";
	}
	
	//즐겨찾기 추가
	@RequestMapping("/userInsertVideo")
	public String userInsertVideo(HttpServletRequest request, Model model){
		IDao dao=sqlSession.getMapper(IDao.class);
		HttpSession httpSession=request.getSession(true);
		String userId=(String) httpSession.getAttribute("userId");
		String rNum=request.getParameter("rNums");
		String vNum=request.getParameter("vNums");
		String uI=request.getParameter("userInterestss");
		String vImage=request.getParameter("vImages");
		String vTilte=request.getParameter("vTitles");
		String vContent=request.getParameter("vContents");
		videoType=uI;
		allVNum=vNum;
		System.out.println("userInsertVideo rNum : "+rNum );
		System.out.println("userInsertVideo vNum : "+vNum );
		System.out.println("userInsertVideo uI : "+uI );
		if (vNum==null) {
			vNum=allVNum;
		}
		if (uI==null) {
			uI=videoType;
		}
		dao.userInVideo(rNum,userId,vImage,vTilte,vContent);
		return "redirect:videoView";
	}
	
	
}
