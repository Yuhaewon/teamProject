//package com.java.spring_myprj.QnA_command;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.ui.Model;
//
//import com.java.spring_myprj.QnA_dao.QDao;
//import com.java.spring_myprj.QnA_dto.QDto;
//
//public class QContentCommend implements QCommand {
//
//	@Override
//	public void execute(Model model) {
//		Map<String, Object> map = model.asMap();
//		
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		
//		String qNum = request.getParameter("qNum");
//		System.out.println("qNum : " + qNum);
//		
//		QDao dao = new QDao();
//		
//		QDto dto = dao.contenView(qNum);
//		
//		model.addAttribute("content_view",dto);
//	}
//
//}
