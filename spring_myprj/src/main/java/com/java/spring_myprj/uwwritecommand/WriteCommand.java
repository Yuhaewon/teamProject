package com.java.spring_myprj.uwwritecommand;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.java.spring_myprj.uwcommand.WCommand;
import com.java.spring_myprj.uwwritedao.Dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteCommand implements WCommand {

	@Override
	public void excute(Model model,String a) {
		// 파일 업로드 저장경로 설정 및 파일저장
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession httpSession =request.getSession(true);

		String attachPath = "resources\\upload\\"; //파일 업로드 경로

		String path = request.getSession().getServletContext().getRealPath(attachPath);
		//String path = "D:\\Documents\\Desktop\\스프링\\spring_Home\\spring_myprj\\src\\main\\webapp\\resources\\image";
		System.out.println("주소 : " + path);
		MultipartRequest req = null;
		try {
			req = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//resources/image/logo.png
		
//		String userNick = req.getParameter("userNick");
		String userId = (String) httpSession.getAttribute("userId");
		String wTitle = req.getParameter("wTitle");
		String wContent = req.getParameter("wContent");
		String wFile =req.getFilesystemName("wFile");
		String pFile =req.getFilesystemName("pFile");
		String[] habit=req.getParameterValues("userInterests");
		String userInterests="";
		if (habit!=null && habit.length>0) {
			for (int i = 0; i < habit.length; i++) {
				userInterests+=habit[i];
				if(habit.length>i+1)//마지막이 아님
					userInterests+=",";
			}
		}
		
		System.out.println("userNick" + userId);
		System.out.println("wTitle" + wTitle);
		System.out.println("wContent" + wContent);
		System.out.println("wFile" + wFile);
		System.out.println("pFile" + pFile);
		System.out.println("userInterests" + userInterests);

		Dao dao = new Dao();
		dao.write(wTitle, wContent, userId, wFile, pFile, userInterests);

	}

}
