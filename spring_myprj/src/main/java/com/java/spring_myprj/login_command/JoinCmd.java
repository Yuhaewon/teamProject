package com.java.spring_myprj.login_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.java.spring_myprj.login_dao.LoginDao;

public class JoinCmd implements Command{

	@Override
	public void execute(Model model,HttpServletRequest request, BCryptPasswordEncoder passwordEncoder) {
		Map<String,Object> map=model.asMap();
		request=(HttpServletRequest) map.get("request");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		
		//비밀번호 암호화
		String securityPw=passwordEncoder.encode(userPw);
		System.out.println("securityPw : "+securityPw);
		
		String eMail1=request.getParameter("email1");
		String eMail2=request.getParameter("email2");
		String eMail=eMail1+"@"+eMail2;
		String userGender=request.getParameter("userGender");
		
		String userIden1=request.getParameter("userIden1");
		String userIden2=request.getParameter("userIden2");
		String userIden3=request.getParameter("userIden3");
		String userIden=userIden1+"년"+userIden2+"월"+userIden3+"일";
		
		String userAddr=request.getParameter("userAddr");
		String userPwhint=request.getParameter("userPwhint");
		String userJoin=request.getParameter("userJoin");
		String userNum=request.getParameter("userNum");
		String userNick=request.getParameter("userNick");
		String userName=request.getParameter("userName");
		String userPwCheck=request.getParameter("userPwCheck");
		String userPhone=request.getParameter("userPhone");
		String userPwhintList=request.getParameter("userPwhintList");
		
		String[] habit=request.getParameterValues("userInterests");
		String userInterests="";
		if (habit!=null && habit.length>0) {
			for (int i = 0; i < habit.length; i++) {
				userInterests+=habit[i];
				if(habit.length>i+1)//마지막이 아님
					userInterests+=",";
			}
		}
		
		System.out.println("name : "+userName);
		System.out.println("id : "+userId);
		
		LoginDao dao=new LoginDao();
		dao.join(userId,securityPw,eMail,userGender,userIden,userAddr,userPwhint,userJoin,userInterests,userNum,userNick,userName,userPwCheck,userPhone,userPwhintList);
	}

}
