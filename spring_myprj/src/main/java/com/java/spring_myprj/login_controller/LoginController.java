package com.java.spring_myprj.login_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring_myprj.login_command.Command;
import com.java.spring_myprj.login_command.FindIdCmd;
import com.java.spring_myprj.login_command.FindPwCmd;
import com.java.spring_myprj.login_command.JoinCmd;
import com.java.spring_myprj.login_command.LoginCmd;



@Controller
public class LoginController {
	Command command;
	LoginCmd command2;
	FindPwCmd command3;
	
	
	@RequestMapping("/login")//로그인뷰
	public String log(HttpServletRequest request) {
		HttpSession httpSession = request.getSession(true);
		if (request.getSession()!=null) {
			httpSession.invalidate();
		}
		return "login/login";
	}

	@RequestMapping("/loginAction")//로그인 확인
	public String logMain(HttpServletRequest request,Model model, BCryptPasswordEncoder passwordEncoder) {
		HttpSession httpSession = request.getSession(true);
		model.addAttribute("request",request);
		String mUrl;
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPw");
		if ((id.equals("")||id==null)&&(pass.equals("")||pass==null)) {
			mUrl="login/login";
			httpSession.setAttribute("error","아이디 또는 비밀번호가 입력되지 않았습니다.");
		}
		else{ //메인화면으로 넘어감.
			command2= new LoginCmd();
			mUrl=command2.execute(model, request, passwordEncoder);
				if (mUrl.equals("redirect:/")) {
					httpSession.setAttribute("userId",id);
					mUrl="redirect:/";
				}else{
					mUrl="login/login";
				}
		}
		return mUrl;
	}
	
	@RequestMapping("/join")//회원가입
	public String join() {
		return "login/join";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.POST)
	public String joinForm(HttpServletRequest request,Model model, BCryptPasswordEncoder passwordEncoder) {
		System.out.println("passing joinForm1");
		model.addAttribute("request",request);
		System.out.println("passing joinForm2");
		command=new JoinCmd();
		command.execute(model, request, passwordEncoder);
		System.out.println("passing joinForm3");
		return "login/login";
	}
	
	//아이디, 비밀번호 찾기
	@RequestMapping("/findIdview")
	public String findIdview(){
		return "login/findId";
	}
	
	@RequestMapping("/findPwview")
	public String findPw(){
		return "login/findPw";
	}
	
	@RequestMapping("/findId")
	public String findId(HttpServletRequest request, Model model, BCryptPasswordEncoder passwordEncoder){
		System.out.println("passing findId");
		model.addAttribute("request",request);
		command=new FindIdCmd();
		command.execute(model, request, passwordEncoder);
		
		return "/login/successFindId";
	}
	
	@RequestMapping("/findPwHint")
	public String findPwHint(){
		return "/login/findPwHint";
	}
	
	@RequestMapping("/checkPwhint")
	public String findPw(HttpServletRequest request, Model model, BCryptPasswordEncoder passwordEncoder){
		System.out.println("passing findpw");
		model.addAttribute("request",request);

		String checkPwhintList=request.getParameter("checkPwhintList");
		String checkPwhint=request.getParameter("checkPwhint");
		String checkId=request.getParameter("checkId");
		
		String mUrl;
		if ((checkId.equals("")||checkId==null)&&(checkPwhint.equals("")||checkPwhint==null)) {
			mUrl="/login/findPwHint";
		}
		else{ //메인화면으로 넘어감.
			command3=new FindPwCmd();
			mUrl=command3.execute(model, request, passwordEncoder);
				if (mUrl.equals("/login/successFindPw")) {
					mUrl="/login/successFindPw";
				}else{
					mUrl="/login/findPwHint";
				}
		}
		return mUrl;
	}
	
	
//		return "/login/successFindPw";
	
	
}
