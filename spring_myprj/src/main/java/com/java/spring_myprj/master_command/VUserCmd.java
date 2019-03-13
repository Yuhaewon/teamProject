package com.java.spring_myprj.master_command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.dto.VideoDto;
import com.java.spring_myprj.master_dao.MasterDao;

public class VUserCmd implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String choiceUserId=request.getParameter("choiceUserId");
		MasterDao dao=new MasterDao();
		
		ArrayList<VideoDto> dtos= dao.mUserVideo(choiceUserId);
		model.addAttribute("uVideos",dtos);
	}
}
