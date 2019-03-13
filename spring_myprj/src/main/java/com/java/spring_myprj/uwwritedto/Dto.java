package com.java.spring_myprj.uwwritedto;

import java.sql.Timestamp;

public class Dto {
	
	private int wNum;
	private String userId;
	private String userNick;
	private String wTitle;
	private String wContent;
	private Timestamp wDate;
	private int wHit;
	private String wFile;
	private String wAddr;
	
	
	public Dto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Dto(int wNum, String userId, String userNick, String wTitle, String wContent, Timestamp wDate, int wHit,
			String wFile, String wAddr) {
		
		this.wNum = wNum;
		this.userId = userId;
		this.userNick = userNick;
		this.wTitle = wTitle;
		this.wContent = wContent;
		this.wDate = wDate;
		this.wHit = wHit;
		this.wFile = wFile;
		this.wAddr = wAddr;
	}
	public int getwNum() {
		return wNum;
	}
	public void setwNum(int wNum) {
		this.wNum = wNum;
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
	public String getwTitle() {
		return wTitle;
	}
	public void setwTitle(String wTitle) {
		this.wTitle = wTitle;
	}
	public String getwContent() {
		return wContent;
	}
	public void setwContent(String wContent) {
		this.wContent = wContent;
	}
	public Timestamp getwDate() {
		return wDate;
	}
	public void setwDate(Timestamp wDate) {
		this.wDate = wDate;
	}
	public int getwHit() {
		return wHit;
	}
	public void setwHit(int wHit) {
		this.wHit = wHit;
	}
	public String getwFile() {
		return wFile;
	}
	public void setwFile(String wFile) {
		this.wFile = wFile;
	}
	public String getwAddr() {
		return wAddr;
	}
	public void setwAddr(String wAddr) {
		this.wAddr = wAddr;
	}
	
	
}

