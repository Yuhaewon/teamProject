//package com.java.spring_myprj.QnA_command;
//
//import java.util.ArrayList;
//
//import org.springframework.ui.Model;
//
//import com.java.spring_myprj.QnA_dao.QDao;
//import com.java.spring_myprj.QnA_dto.QDto;
//
//public class QListCommand implements QCommand{
//
//	@Override
//	public void execute(Model model) {
//		QDao dao = new QDao();
//		ArrayList<QDto> dtos = dao.list();
//		
//		model.addAttribute("list",dtos);
//		
//	}
//
//}
//
