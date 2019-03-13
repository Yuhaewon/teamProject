package com.java.spring_myprj.QnA_controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring_myprj.dao.QDao;

import page.conn.SearchVO;

@Controller
public class QController {

	@Autowired
	private SqlSession sqlSession;

	
	@RequestMapping("/qlist")
	public String qlist(HttpServletRequest request, Model model, SearchVO searchVO) {

		String f = request.getParameter("f");

		String qTitle = "";
		String qContent = "";

		String[] brdtitle = request.getParameterValues("searchType");
		System.out.println("searchType >> " + brdtitle);

		if (brdtitle != null) {
			for (String val : brdtitle) {
				System.out.println("val >>" + val);
				if (val.equals("qTitle")) {
					model.addAttribute("qTitle", "true");
					qTitle = "qTitle";
				} else if (val.equals("qContent")) {
					model.addAttribute("qContent", true);
					qContent = "Content";
				}
			}
		}

		String searchKeyword = request.getParameter("sk");
		if (searchKeyword == null) {
			searchKeyword = "";
		}
		QDao dao = sqlSession.getMapper(QDao.class);

		int total2 = 0;

		if (f != null && f.equals("qTitle")) {
			total2 = dao.selectBoard2Count1(searchKeyword);
			System.out.println("go total > list1");
		} else if (f != null && f.equals("qContent")) {
			total2 = dao.selectBoard2Count2(searchKeyword);
			System.out.println("go total > list2");
		} else if (f != null && f.equals("btit_bcon")) {
			total2 = dao.selectBoard2Count3(searchKeyword);
			System.out.println("go total > list3");
		} else {
			total2 = dao.selectBoard2Count0(searchKeyword);
			System.out.println("go total > list0");
		}

		int total = dao.sqlTotRowCount();
		String strPage = request.getParameter("page");

		System.out.println("searchKeyword >>"+searchKeyword);
		model.addAttribute("searchKeyword",searchKeyword);
		
		if (strPage == null || strPage.equals("")) {
			strPage = "1";
		}

		int page = Integer.parseInt(strPage);
		searchVO.setPage(page);
		
		searchVO.pageCalculate(total);

		int rowStart = searchVO.getRowStart();
		int rowEnd = searchVO.getRowEnd();
		
		System.out.println("qTitle>>"+qTitle);
		System.out.println("qContent>>"+qContent);
	
		if(f!=null && f.equals("qTitle")) {
			model.addAttribute("list", dao.list1(rowStart,rowEnd,searchKeyword));
			model.addAttribute("totRowCnt", dao.selectBoard2Count1(searchKeyword));
			System.out.println("gogo >list1");
		}else if(f!=null && f.equals("qContent")) {
			model.addAttribute("list", dao.list2(rowStart,rowEnd,searchKeyword));
			model.addAttribute("totRowCnt", dao.selectBoard2Count2(searchKeyword));
			System.out.println("gogo >list2");
		}else if(f!=null && f.equals("btit_bcon")) {
			model.addAttribute("list", dao.list3(rowStart,rowEnd,searchKeyword));
			model.addAttribute("totRowCnt", dao.selectBoard2Count3(searchKeyword));
			System.out.println("gogo >list3");
		}else {
			model.addAttribute("list", dao.list0(rowStart,rowEnd,searchKeyword));
			model.addAttribute("totRowCnt", dao.selectBoard2Count0(searchKeyword));
			System.out.println("gogo >list0");
		}

		model.addAttribute("searchVO", searchVO);
		return "qna/qlist";
	}

	@RequestMapping("/qwrite_view")
	public String write_view() {
		System.out.println("passing write()");
		return "qna/qwrite_view";
	}

	@RequestMapping("/qcontent_view")
	public String modify_view(HttpServletRequest request, Model model) {
		System.out.println("passing content_view()");

		String qNum = request.getParameter("qNum");
		System.out.println("qNum" + qNum);

		QDao dao = sqlSession.getMapper(QDao.class);
		dao.upHit(qNum);
		model.addAttribute("content_view", dao.contenView(qNum));
		return "qna/qcontent_view";
	}

	@RequestMapping("/qwrite")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("passing write()");
		HttpSession httpSession=request.getSession(true);
		String userId=(String) httpSession.getAttribute("userId");
		String qTitle = request.getParameter("qTitle");
		String qContent = request.getParameter("qContent");

		QDao dao = sqlSession.getMapper(QDao.class);
		dao.write(userId, qTitle, qContent);
		return "redirect:qlist";
	}

	@RequestMapping(value = "/qmodify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("passing modify()");
		String qNum = request.getParameter("qNum");
		String userId = request.getParameter("userId");
		String qTitle = request.getParameter("qTitle");
		String qContent = request.getParameter("qCBerkioaontent");

		// model.addAttribute("request", request);
		QDao dao = sqlSession.getMapper(QDao.class);
		dao.modify(qNum, userId, qTitle, qContent);

		// command = new QModifyCommand();
		// command.execute(model);
		return "redirect:qlist";
	}

	@RequestMapping("/qdeleted")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("passing delete()");
		String qNum = request.getParameter("qNum");
		// model.addAttribute("request", request);
		QDao dao = sqlSession.getMapper(QDao.class);
		dao.delete(qNum);
		// command = new QDeleteCommand();
		// command.execute(model);
		return "redirect:qlist";
	}

	@RequestMapping("/qreply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("passing reply_view()");
		String strId = request.getParameter("qNum");
		QDao dao = sqlSession.getMapper(QDao.class);
		model.addAttribute("reply_view", dao.reply_view(strId));
		return "qna/qreply_view";
	}

	@RequestMapping("/qreply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("passing reply_view()");

		HttpSession httpSession=request.getSession(true);
		String userId=(String) httpSession.getAttribute("userId");
		String qNum = request.getParameter("qNum");
		String qTitle = request.getParameter("qTitle");
		String qContent = request.getParameter("qContent");
		String qGroup = request.getParameter("qGroup");
		String qStep = request.getParameter("qStep");
		String qIndent = request.getParameter("qIndent");

		QDao dao = sqlSession.getMapper(QDao.class);
		dao.reply(userId, qTitle, qContent, qGroup, qStep, qIndent);

		return "redirect:qlist";

	}

}
