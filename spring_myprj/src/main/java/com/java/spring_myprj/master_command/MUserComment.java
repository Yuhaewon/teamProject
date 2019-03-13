package com.java.spring_myprj.master_command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.dto.review.ReviewDto;
import com.java.spring_myprj.master_dao.MasterDao;

public class MUserComment implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String choiceUserId=request.getParameter("choiceUserId");
		System.out.println("userId3 : "+choiceUserId);
		MasterDao dao=new MasterDao();
		ArrayList<ReviewDto> dtos= dao.mUserComment(choiceUserId);
		model.addAttribute("uComment",dtos);
	}

}
