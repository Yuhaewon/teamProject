package com.java.spring_myprj.dao;

import java.util.ArrayList;

import com.java.spring_myprj.QnA_dto.QDto;

public interface QDao {

	
	public ArrayList<QDto> list0(int start,int end,String searchKeyword);
	public ArrayList<QDto> list1(int start,int end,String searchKeyword);
	public ArrayList<QDto> list2(int start,int end,String searchKeyword);
	public ArrayList<QDto> list3(int start,int end,String searchKeyword);
	
	public int selectBoard2Count0(String searchKeyword);
	public int selectBoard2Count1(String searchKeyword);
	public int selectBoard2Count2(String searchKeyword);
	public int selectBoard2Count3(String searchKeyword);
	
	public ArrayList<QDto> list(int rowStart,int rowEnd);
	public void write(String userId, String qTitle, String qContent);
	public void modify(String qNum, String userId, String qTitle, String qContent);
	public QDto contenView(String strNum);
	public void upHit(String qNum);
	public void delete(String qNum);
	
	public QDto reply_view(String strId);
	public int sqlTotRowCount();
	public void reply(String userId, String qTitle, String qContent, String qGroup, String qStep, String qIndent);
}
