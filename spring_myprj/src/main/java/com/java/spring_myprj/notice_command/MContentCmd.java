package com.java.spring_myprj.notice_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.notice_dao.NoticeDao;
import com.java.spring_myprj.notice_dto.NoticeDto;

public class MContentCmd implements MCmd{

	@Override
	public void execute(Model model) {
		Map<String,Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String master=request.getParameter("master");
		
		NoticeDao dao=new NoticeDao();
		NoticeDto dto=dao.contentView(master);
		
		model.addAttribute("content_view",dto);
	}
	
}
