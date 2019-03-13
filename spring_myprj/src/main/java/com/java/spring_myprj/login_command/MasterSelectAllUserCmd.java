package com.java.spring_myprj.login_command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.java.spring_myprj.login_dto.LoginDto;
import com.java.spring_myprj.master_command.Command;
import com.java.spring_myprj.master_dao.MasterDao;

public class MasterSelectAllUserCmd implements Command{

	@Override
	public void execute(Model model) {

		MasterDao dao=new MasterDao();
		ArrayList<LoginDto> dtos=dao.selectAll();
		model.addAttribute("selectAll",dtos);
	}
	
}
