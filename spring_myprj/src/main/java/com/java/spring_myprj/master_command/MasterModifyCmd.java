package com.java.spring_myprj.master_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.master_dao.MasterDao;

public class MasterModifyCmd implements Command{

	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String CuserNick=request.getParameter("CuserNick");
		String userNum=request.getParameter("userNum");
		
		System.out.println("CuserNick : "+CuserNick);
		System.out.println("userNum : "+userNum);
		
		MasterDao dao=new MasterDao();
		dao.nickModify(CuserNick, userNum);
	}

}
