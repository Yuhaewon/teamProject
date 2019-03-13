package com.java.spring_myprj.login_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.java.spring_myprj.login_dao.LoginDao;

public class FindPwCmd implements Command3{
	boolean result;
	
	@Override
	public String execute(Model model, HttpServletRequest request, BCryptPasswordEncoder passwordEncoder) {
		Map<String, Object> map=model.asMap();
		request=(HttpServletRequest) map.get("request");
		
		String checkPwhintList=request.getParameter("checkPwhintList");
		String checkPwhint=request.getParameter("checkPwhint");
		String checkId=request.getParameter("checkId");
		String url = "";
		
		// 해당 아이디가 있는지 체크
		LoginDao dao=new LoginDao();
		if (!(checkId.equals("") || checkId==null)) {
			result = dao.login(checkId); 
			System.out.println("/login/findPwHint result:"+result);
			//아이디가 존재하지 않는다면
			if (result == false) {
				url = "/login/findPwHint";
				System.out.println("/login/findPwHint3");
			}else if(result == true) {
				String checkPwhintOk = dao.hint_check(checkId,checkPwhintList);
				System.out.println("checkPwhintOk : "+checkPwhintOk);
				System.out.println("checkPwhint : "+checkPwhint);
				if(checkPwhintOk.equals(checkPwhint)) {
					System.out.println("/login/successFindPw1");
					url="/login/successFindPw";
				}else if(!checkPwhintOk.equals(checkPwhint)) {
					System.out.println("/login/findPwHint2");
					url="/login/findPwHint";
				}
			}
		} 
		System.out.println("checkPwhintList : "+checkPwhintList);
		System.out.println("checkPwhint : "+checkPwhint);
		System.out.println("checkId : "+checkId);
		
		model.addAttribute("SfindPw",dao.findPw(checkPwhintList,checkPwhint,checkId));
		System.out.println("url : "+url);
		return url;
	}
}
