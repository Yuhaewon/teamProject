package com.java.spring_myprj.notice_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.notice_dao.NoticeDao;

public class MWriteCmd implements MCmd{

	@Override
	public void execute(Model model) {
		Map<String,Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String master=request.getParameter("master");
		String mTitle=request.getParameter("mTitle");
		String mContent=request.getParameter("mContent");
		
		System.out.println("cmd : "+master+","+mTitle+","+mContent);
		
		NoticeDao dao=new NoticeDao();
		dao.write(master,mTitle,mContent);
	}
	
}
