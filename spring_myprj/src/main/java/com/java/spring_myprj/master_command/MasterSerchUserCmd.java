package com.java.spring_myprj.master_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.master_dao.MasterDao;

public class MasterSerchUserCmd implements Command{

	@Override
	public void execute(Model model) {
		Map<String,Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String sUser=request.getParameter("sUser");
		
		System.out.println("sUser : "+sUser);
		
		MasterDao dao=new MasterDao();
		request.setAttribute("seUser", dao.serchUser(sUser));
		System.out.println("dao.serchUser(sUser) : "+dao.serchUser(sUser));
	}

}
