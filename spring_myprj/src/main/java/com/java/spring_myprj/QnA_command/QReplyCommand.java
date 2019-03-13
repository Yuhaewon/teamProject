//package com.java.spring_myprj.QnA_command;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.ui.Model;
//
//import com.java.spring_myprj.QnA_dao.QDao;
//
//public class QReplyCommand implements QCommand {
//
//	@Override
//	public void execute(Model model) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//
//		String qNum = request.getParameter("qNum");
//		String userNick = request.getParameter("userNick");
//		String qTitle = request.getParameter("qTitle");
//		String qContent = request.getParameter("qContent");
//		String qGroup = request.getParameter("qGroup");
//		String qStep = request.getParameter("qStep");
//		String qIndent = request.getParameter("qIndent");
//		
//		QDao dao = new QDao();
//		dao.reply(qNum,userNick,qTitle,qContent,qGroup,qStep,qIndent);
//		
//	}
//
//}
