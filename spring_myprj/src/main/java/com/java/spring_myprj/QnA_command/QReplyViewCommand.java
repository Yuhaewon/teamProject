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
//public class QReplyViewCommand implements QCommand{
//
//	@Override
//	public void execute(Model model) {
//	Map<String, Object> map = model.asMap();
//	HttpServletRequest request = (HttpServletRequest) map.get("request");
//	String qNum = request.getParameter("qNum");
//	
//	QDao dao = new QDao();
//	QDto dto = dao.reply_view(qNum);
//	model.addAttribute("reply_view",dto);
//		
//	}
//
//}
