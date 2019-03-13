package com.java.spring_myprj.login_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.java.spring_myprj.login_dao.LoginDao;

public class LoginCmd implements Command2 {
	boolean result;

	@Override
	public String execute(Model model, HttpServletRequest request, BCryptPasswordEncoder passwordEncoder) {
		HttpSession httpSession = request.getSession(true);
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String url = "";
		LoginDao dao = new LoginDao();
		if (userId.equals("masterH")) {
			result = dao.master_login(userId);
			System.out.println("master_login");
			if (result == false) {
				url = "/login/login";
				httpSession.setAttribute("error", "존재하지 않는 아이디입니다.");
			}else if (result == true) {// 해당 아이디가 있을 때
				String checkPw1 = dao.master_loginCheck(userId); // 해당 아이디의 비밀번호 체크
				System.out.println("checkPw1 : " + checkPw1);
				if (userPw.equals(checkPw1)) {
					url = "redirect:/";
				} else if (!(userPw.equals(checkPw1))) {
					url = "/login/login";
					httpSession.setAttribute("error", "비밀번호가 일치하지 않습니다.");
				}
			}
		}
		if (!(userId.equals("masterH"))) {
			result = dao.login(userId); // 해당 아이디가 있는지 체크
			System.out.println("user_login");
			if (result == false) {
				url = "/login/login";
				httpSession.setAttribute("error", "존재하지 않는 아이디입니다.");
			}else if (result == true) {// 해당 아이디가 있을 때
				String checkPw1 = dao.loginCheck(userId); // 해당 아이디의 비밀번호 체크
				System.out.println("checkPw2 : " + checkPw1);
				if (passwordEncoder.matches(userPw, checkPw1)) {
					url = "redirect:/";
				} else if (!(passwordEncoder.matches(userPw, checkPw1))) {
					url = "/login/login";
					httpSession.setAttribute("error", "비밀번호가 일치하지 않습니다.");
				}
			}
		}
		return url;
	}
}

/*else if (!(userId.equals("masterH"))) {
	String checkPw = dao.loginCheck(userId); // 해당 아이디의 비밀번호 체크
	System.out.println("checkPw : " + checkPw);
	if ((userPw.equals(checkPw)) || (passwordEncoder.matches(userPw, checkPw))) {
		url = "redirect:/";
	} else if ((!(userPw.equals(checkPw))) && (!passwordEncoder.matches(userPw, checkPw))) {
		url = "/login/login";
		httpSession.setAttribute("error", "비밀번호가 일치하지 않습니다.");
	}
}*/
/*if (result == false) {
			url = "/login/login";
			httpSession.setAttribute("error", "존재하지 않는 아이디입니다.");
		} else if (result == true) {// 해당 아이디가 있을 때
			if (userId.equals("masterH")) {
				String checkPw1 = dao.master_loginCheck(userId); // 해당 아이디의 비밀번호 체크
				System.out.println("checkPw : " + checkPw1);
				if ((userPw.equals(checkPw1)) || (passwordEncoder.matches(userPw, checkPw1))) {
					url = "redirect:/";
				} else if ((!(userPw.equals(checkPw1))) && (!passwordEncoder.matches(userPw, checkPw1))) {
					url = "/login/login";
					httpSession.setAttribute("error", "비밀번호가 일치하지 않습니다.");
				}
			}
			if (!(userId.equals("masterH"))) {
				String checkPw2 = dao.loginCheck(userId); // 해당 아이디의 비밀번호 체크
				System.out.println("checkPw : " + checkPw2);
				if (!(userPw.equals(checkPw2))) {
					if (!(passwordEncoder.matches(userPw, checkPw2))) {
						url = "/login/login";
						httpSession.setAttribute("error", "비밀번호가 일치하지 않습니다.");
					}else if(passwordEncoder.matches(userPw, checkPw2)){
						url = "redirect:/";
					}
				}else if (userPw.equals(checkPw2)) {
					url = "redirect:/";
				}
				
			}
			if (result == false) { // 해당 아이디가 없을 때
				url = "/login/login";
				httpSession.setAttribute("error", "존재하지 않는 아이디입니다.");
			}
			return url;
		}
		if (result == false) { // 해당 아이디가 없을 때
			url = "/login/login";
			httpSession.setAttribute("error", "존재하지 않는 아이디입니다.");
		}*/