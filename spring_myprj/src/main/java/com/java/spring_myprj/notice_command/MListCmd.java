package com.java.spring_myprj.notice_command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.java.spring_myprj.notice_dao.NoticeDao;
import com.java.spring_myprj.notice_dto.NoticeDto;

public class MListCmd implements MCmd{
	
	@Override
	public void execute(Model model) {
		NoticeDao dao=new NoticeDao();
		
		ArrayList<NoticeDto> dtos=dao.list();
		
		model.addAttribute("lists",dtos);
	}
}
