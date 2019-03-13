package com.java.spring_myprj.uwcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring_myprj.uwcommand.WCommand;
import com.java.spring_myprj.uwutil.Constant;
import com.java.spring_myprj.uwwritecommand.ContentCommand;
import com.java.spring_myprj.uwwritecommand.DeleteCommand;
import com.java.spring_myprj.uwwritecommand.ModifyCommand;
import com.java.spring_myprj.uwwritecommand.WriteCommand;
import com.java.spring_myprj.uwwritecommand.listCommand;

@Controller
public class WController {

	WCommand command;

	public JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	// 게시판 리스트

/*	@RequestMapping("/mypageInserVideo")
	public String list(HttpServletRequest request, Model model) {
		String strPage = request.getParameter("page");
		System.out.println("33Controller page " + strPage);
		if (strPage == null) {
			strPage = "1";
		}
		System.out.println("44Controller page" + strPage);

		System.out.println("passing list22()");
		command = new listCommand();
		command.excute(model, strPage);
		System.out.println("dao.list2222222222");

		return "mypage/mypageInserVideo";

	}*/

	// 작성화면

	@RequestMapping("/write_view")
	public String writeView(Model model) {
		return "/mypage/write_view";

	}

	// 작성시 리스트로 동작

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){
		System.out.println("passing write555555555555555555555");

		model.addAttribute("request", request);

		command = new WriteCommand();
		command.excute(model, "0");

		return "redirect:/mypageInserVideo";

	}

	// 삭제

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("passing delete()");

		model.addAttribute("request", request);

		command = new DeleteCommand();
		command.excute(model, "0");

		return "redirect:/mypageInserVideo";

	}

	// 자세히보기
	
	@RequestMapping("/content_view")
	public String modify_view(HttpServletRequest request, Model model) {
		System.out.println("passing content_view()");

		model.addAttribute("request", request);

		command = new ContentCommand();
		command.excute(model, "0");

		return "/mypage/content_view";
	}
	
	// 수정

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("passing modify()");

		model.addAttribute("request", request);

		command = new ModifyCommand();
		command.excute(model, "0");

		return "redirect:/mypageInserVideo";

	}
}