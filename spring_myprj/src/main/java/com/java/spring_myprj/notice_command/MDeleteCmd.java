package com.java.spring_myprj.notice_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.notice_dao.NoticeDao;

public class MDeleteCmd implements MCmd{

	@Override
	public void execute(Model model) {
		Map<String,Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String mNum=request.getParameter("mNum");
		NoticeDao dao=new NoticeDao();
		
		dao.delete(mNum);
		
	}
	
}
