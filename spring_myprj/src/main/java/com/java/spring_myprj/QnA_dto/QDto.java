package com.java.spring_myprj.QnA_dto;

import java.sql.Timestamp;

public class QDto {

	private int qNum;
	private String userId;
	private String userNick;
	private String qTitle;
	private String qContent;
	private Timestamp qDate;
	private int qScheck;
	private int qHit;
	private int qGroup;
	private int qStep;
	private int qIndent;
	
	public QDto() {
		// TODO Auto-generated constructor stub
	}
	
	public QDto(int qNum, String userId, String userNick, String qTitle, String qContent, Timestamp qDate, int qScheck,
			int qHit, int qGroup, int qStep, int qIndent) {
		
		this.qNum = qNum;
		this.userId = userId;
		this.userNick = userNick;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qDate = qDate;
		this.qScheck = qScheck;
		this.qHit = qHit;
		this.qGroup = qGroup;
		this.qStep = qStep;
		this.qIndent = qIndent;
	}

	public int getqNum() {
		return qNum;
	}

	public void setqNum(int qNum) {
		this.qNum = qNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public Timestamp getqDate() {
		return qDate;
	}

	public void setqDate(Timestamp qDate) {
		this.qDate = qDate;
	}

	public int getqScheck() {
		return qScheck;
	}

	public void setqScheck(int qScheck) {
		this.qScheck = qScheck;
	}

	public int getqHit() {
		return qHit;
	}

	public void setqHit(int qHit) {
		this.qHit = qHit;
	}

	public int getqGroup() {
		return qGroup;
	}

	public void setqGroup(int qGroup) {
		this.qGroup = qGroup;
	}

	public int getqStep() {
		return qStep;
	}

	public void setqStep(int qStep) {
		this.qStep = qStep;
	}

	public int getqIndent() {
		return qIndent;
	}

	public void setqIndent(int qIndent) {
		this.qIndent = qIndent;
	}
	

	
	
	
}