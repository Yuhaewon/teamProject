package com.java.spring_myprj.login_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.java.spring_myprj.login_dao.LoginDao;

public class FindIdCmd implements Command {

	@Override
	public void execute(Model model, HttpServletRequest request, BCryptPasswordEncoder passwordEncoder) {
		Map<String, Object> map=model.asMap();
		request=(HttpServletRequest) map.get("request");
		
		String findName=request.getParameter("findName");
		String findbirth=request.getParameter("findbirth");
		
		LoginDao dao=new LoginDao();
		model.addAttribute("SfindId",dao.findId(findName,findbirth));
		
	}
}
