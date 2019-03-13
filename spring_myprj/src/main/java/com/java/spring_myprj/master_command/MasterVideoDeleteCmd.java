package com.java.spring_myprj.master_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.master_dao.MasterDao;

public class MasterVideoDeleteCmd implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String vNum=request.getParameter("vNum");
		
		MasterDao dao=new MasterDao();
		dao.videoDelete(vNum);
	}

}
