package com.java.spring_myprj.dto.review;

import java.sql.Timestamp;

public class ReviewDto {
	private int rNum;
	private int vNum;
	private String userNick;
	private String rContent;
	private String userId;
	private Timestamp rDate;

	public ReviewDto() {
	}

	public ReviewDto(int rNum, String userNick, String rContent, Timestamp rDate, int vNum, String userId) {
		this.rNum = rNum;
		this.userNick = userNick;
		this.rContent = rContent;
		this.userId = userId;
		this.rDate = rDate;
		this.vNum = vNum;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public Timestamp getrDate() {
		return rDate;
	}

	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}

	public int getvNum() {
		return vNum;
	}

	public void setvNum(int vNum) {
		this.vNum = vNum;
	}
	
}
