package com.java.spring_myprj.favideo.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_myprj.favideo.dao.vDao;
import com.java.spring_myprj.favideo.dto.vDto;

import gu.common.SearchVO;

public class vlistCommand implements vCommand {

	@Override
	public void excute(Model model, String strPage) {
		vDao dao1 = new vDao();
		SearchVO searchVO = new SearchVO();
		int total = dao1.selectBoard2Count();
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		System.out.println("reques22222222t"+request);
		
		System.out.println("strPage >>" + strPage);
	
		if (strPage==null) {
			strPage="1";
		}
		System.out.println("strPage >>"+strPage);
		
		int page=Integer.parseInt(strPage);
		searchVO.setPage(page);
		
		searchVO.pageCalculate(total);
		
		System.out.println("레코드 총수 "+ dao1.selectBoard2Count());
		
		System.out.println("pageStart "+ searchVO.getPageStart());
		System.out.println("pageEnd "+ searchVO.getPageEnd());
		System.out.println("pageTotal "+ searchVO.getTotPage());
		System.out.println("rowStart "+ searchVO.getRowStart());
		System.out.println("rowEnd "+ searchVO.getRowEnd());
		
		int rowStart=searchVO.getRowStart();
		int rowEnd=searchVO.getRowEnd();
		
		model.addAttribute("totRowCnt", dao1.selectBoard2Count());
		model.addAttribute("searchVO",searchVO );
		
		ArrayList<vDto> dtos= dao1.list(rowStart,rowEnd);
		model.addAttribute("list",dtos);
			
	}

}
