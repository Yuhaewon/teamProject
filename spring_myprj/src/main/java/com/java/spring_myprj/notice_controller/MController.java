package com.java.spring_myprj.notice_controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring_myprj.notice_command.MCmd;
import com.java.spring_myprj.notice_command.MContentCmd;
import com.java.spring_myprj.notice_command.MDeleteCmd;
import com.java.spring_myprj.notice_command.MListCmd;
import com.java.spring_myprj.notice_command.MModifyCmd;
import com.java.spring_myprj.notice_command.MWriteCmd;

@Controller
public class MController {
	MCmd cmd;
	
	@RequestMapping("/list")
	public String list(Model model) {
		cmd=new MListCmd();
		cmd.execute(model);
		return "notice/list";
	}
	@RequestMapping("/m_write_view")
	public String write_view() {
		System.out.println("passing write_view");
		return "notice/m_write_view";
	}
	@RequestMapping("/m_content_view")
	public String content_view(HttpServletRequest request,Model model) {
			model.addAttribute("request",request);
			cmd=new MContentCmd();
			cmd.execute(model);
		return "notice/m_content_view";
	}
	@RequestMapping("/mwrite")
	public String write(HttpServletRequest request,Model model) {
		System.out.println("passing write");
		model.addAttribute("request",request);
		cmd=new MWriteCmd();
		cmd.execute(model);
		return "redirect:list";
	}
	@RequestMapping("/m_modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("passing modify");
		model.addAttribute("request",request);
		cmd=new MModifyCmd();
		cmd.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/mdelete")
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("passing delete");
		model.addAttribute("request",request);
		cmd=new MDeleteCmd();
		cmd.execute(model);
		return "redirect:list";
	}
}
