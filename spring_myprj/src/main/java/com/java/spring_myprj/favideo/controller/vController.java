package com.java.spring_myprj.favideo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring_myprj.favideo.command.vCommand;
import com.java.spring_myprj.favideo.command.vlistCommand;
import com.java.spring_myprj.favideo.util.Constant;

@Controller
public class vController {

	vCommand command;

	public JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping("/mypageFaVideo")
	public String list(HttpServletRequest request, Model model) {

		System.out.println("passing list()");
		String strPage = request.getParameter("page");
		System.out.println("11Controller page" + strPage);
		if (strPage == null) {
			strPage = "1";
		}
		
		System.out.println("22Controller page" + strPage);
		
		command = new vlistCommand();
		command.excute(model, strPage);
		System.out.println("dao.list");

		return "mypage/mypageFaVideo";
	}
}
