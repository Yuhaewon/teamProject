package com.java.spring_myprj.uwwritecommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.uwcommand.WCommand;
import com.java.spring_myprj.uwwritedao.Dao;

public class ModifyCommand implements WCommand {

	@Override
	public void excute(Model model,String a) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String wNum = request.getParameter("wNum");
		String userNick = request.getParameter("userNick");
		String wTitle = request.getParameter("wTitle");
		String wFile = request.getParameter("wFile");
		String wContent = request.getParameter("wContent");
		
		Dao dao = new Dao();
		dao.modify(wNum,userNick,wTitle,wFile,wContent);
		
		
	}

}
