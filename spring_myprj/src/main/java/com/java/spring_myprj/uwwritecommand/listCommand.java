package com.java.spring_myprj.uwwritecommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.dto.VideoDto;
import com.java.spring_myprj.uwcommand.WCommand;
import com.java.spring_myprj.uwwritedao.Dao;
import com.java.spring_myprj.uwwritedto.Dto;

import gu.common.SearchVO;

public class listCommand implements WCommand {

	@Override
	public void excute(Model model, String strPage) {
		Dao dao = new Dao();
		SearchVO searchVO = new SearchVO();
		int total = dao.selectBoard1Count();

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		System.out.println("req111111111111uest" + request);

		System.out.println("strPage2 >>" + strPage);

		if (strPage == null) {
			strPage = "1";
		}
		System.out.println("strPage2 >>" + strPage);

		int page = Integer.parseInt(strPage);
		searchVO.setPage(page);

		searchVO.pageCalculate(total);
		
		System.out.println("레코드 총수" + dao.selectBoard1Count());

		System.out.println("pageStart " + searchVO.getPageStart());
		System.out.println("pageEnd " + searchVO.getPageEnd());
		System.out.println("pageTotal " + searchVO.getTotPage());
		System.out.println("rowStart " + searchVO.getRowStart());
		System.out.println("rowEnd " + searchVO.getRowEnd());

		int rowStart = searchVO.getRowStart();
		int rowEnd = searchVO.getRowEnd();

		model.addAttribute("totRowCnt", dao.selectBoard1Count());
		model.addAttribute("searchVO", searchVO);

		ArrayList<VideoDto> dtos = dao.list(rowStart, rowEnd);
		model.addAttribute("list", dtos);

		System.out.println("list2222222222222");

		model.addAttribute("list2", dtos);

	}

}
