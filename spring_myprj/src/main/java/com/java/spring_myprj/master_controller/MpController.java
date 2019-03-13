package com.java.spring_myprj.master_controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring_myprj.login_command.MasterSelectAllUserCmd;
import com.java.spring_myprj.master_command.CUserCmd;
import com.java.spring_myprj.master_command.Command;
import com.java.spring_myprj.master_command.MUserComment;
import com.java.spring_myprj.master_command.MasterChartJoinUserCmd;
import com.java.spring_myprj.master_command.MasterCommentDeleteCmd;
import com.java.spring_myprj.master_command.MasterModifyCmd;
import com.java.spring_myprj.master_command.MasterSerchUserCmd;
import com.java.spring_myprj.master_command.MasterUserDeleteCmd;
import com.java.spring_myprj.master_command.MasterVideoDeleteCmd;
import com.java.spring_myprj.master_command.VUserCmd;

@Controller
public class MpController {
	Command cmd;

	@RequestMapping("/masterpage")
	public String master() {

		return "master/masterpage";
	}

	@RequestMapping("/master/mpSelectUser")
	public String mpSelect(Model model) {
		cmd=new MasterSelectAllUserCmd();
		cmd.execute(model);
		return "master/mpSelectUser";
	}
	
	@RequestMapping("/master/choiceUser")
	public String choiceUser(HttpServletRequest request, Model model){
		System.out.println("passing choiceUser");
		model.addAttribute("request",request);
		String choiceUserId=request.getParameter("choiceUserId");
		cmd=new MasterSelectAllUserCmd();
		cmd.execute(model);
		
		cmd=new CUserCmd();
		cmd.execute(model);
		
		return "/master/mpSelectUser";
	}
	
	@RequestMapping("/master/mpUserVideo")
	public String mpUserVideo(HttpServletRequest request, Model model){
		System.out.println("passing mpUserVideo");
		model.addAttribute("request",request);
		
		//유저조회
		cmd=new MasterSelectAllUserCmd();
		cmd.execute(model);
		
		cmd=new VUserCmd();
		cmd.execute(model);
		
		return "/master/mpUserVideo";
	}
	
	@RequestMapping("/master/mpUserComment")
	public String mpUserComment(HttpServletRequest request,Model model) {
		System.out.println("passing mpUserComment");
		
		model.addAttribute("request",request);
		cmd=new MasterSelectAllUserCmd();
		cmd.execute(model);
		
		cmd=new MUserComment();
		cmd.execute(model);
		
		return "/master/mpUserComment";
	}
	
	@RequestMapping("/master/serchUser")
	public String serchUser(HttpServletRequest request,Model model) {
		System.out.println("passing serchUser");
		model.addAttribute("request",request);
		
		cmd=new MasterSerchUserCmd();
		cmd.execute(model);
		
		return "/master/mpSelectUser";
	}
	
	
	@RequestMapping("/master/mpUserDelete")
	public String userDelete(HttpServletRequest request,Model model) {
		System.out.println("passing UserDelete");
		model.addAttribute("request",request);
		cmd=new MasterSelectAllUserCmd();
		cmd.execute(model);
		cmd=new MasterUserDeleteCmd();
		cmd.execute(model);
		
		return "redirect:/master/mpSelectUser";
	}
	
	@RequestMapping("/master/mpVideoDelete")
	public String mpVideoDelete(HttpServletRequest request,Model model) {
		System.out.println("passing VideoDelete");
		String reUserId=request.getParameter("reUserId");
		
		System.out.println("reUserId : "+reUserId);
		model.addAttribute("request",request);
		cmd=new MasterVideoDeleteCmd();
		cmd.execute(model);
		
		return "redirect:/master/mpUserVideo?choiceUserId="+reUserId;
	}
	
	@RequestMapping("/master/mpCommentDelete")
	public String mpCommentDelete(HttpServletRequest request,Model model) {
		System.out.println("passing CommentDelete");
		String choiceNick=request.getParameter("choiceNick");
		System.out.println("choiceNick : "+choiceNick);
		model.addAttribute("request",request);
		cmd=new MasterCommentDeleteCmd();
		cmd.execute(model);
		return "redirect:/master/mpUserComment?choiceUserId="+choiceNick;
	}
	
	@RequestMapping("/master/nickModify")
	public String nickModify(HttpServletRequest request, Model model) {
		System.out.println("passing nickModify");
		// 수정후 반환값
		String CuserId=request.getParameter("CuserId");
		System.out.println("CuserId : "+CuserId);
		model.addAttribute("request",request);
		cmd=new MasterModifyCmd();
		cmd.execute(model);
		
		return "redirect:/master/choiceUser?choiceUserId="+CuserId;
	}
	
	@RequestMapping("/master/masterChart")
	public String masterChart(Model model){
		System.out.println("passing masterChart");
		cmd=new MasterChartJoinUserCmd();
		cmd.execute(model);
		
		return "/master/masterChart";
	}
	
}