package com.java.spring_myprj.uwwritecommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.uwcommand.WCommand;
import com.java.spring_myprj.uwwritedao.Dao;

public class DeleteCommand implements WCommand {

	@Override
	public void excute(Model model,String a) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String wNum = request.getParameter("wNum");
		Dao dao = new Dao();
		
		dao.delete(wNum);
		
	}

}
