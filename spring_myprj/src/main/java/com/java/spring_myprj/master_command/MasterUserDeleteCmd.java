package com.java.spring_myprj.master_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.master_dao.MasterDao;

public class MasterUserDeleteCmd implements Command{

	@Override
	public void execute(Model model) {
		Map<String,Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String userId=request.getParameter("userId");
		System.out.println("userId1 : "+userId);
		
		MasterDao dao=new MasterDao();
		System.out.println("userId2 : "+userId);
		dao.userDelete(userId);
	}

}
