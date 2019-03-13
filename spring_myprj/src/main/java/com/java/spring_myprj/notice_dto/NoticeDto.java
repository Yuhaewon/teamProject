package com.java.spring_myprj.notice_dto;

import java.sql.Timestamp;

public class NoticeDto {
	private String master;
	private int mNum;
	private Timestamp mDate;
	private String mTitle;
	private String mContent;
	private int mHit;
	private String mFile;
	
	public NoticeDto(String master, int mNum, Timestamp mDate, String mTitle, String mContent, int mHit, String mFile) {
		this.master = master;
		this.mNum = mNum;
		this.mDate = mDate;
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.mHit = mHit;
		this.mFile = mFile;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public int getmNum() {
		return mNum;
	}

	public void setmNum(int mNum) {
		this.mNum = mNum;
	}

	public Timestamp getmDate() {
		return mDate;
	}

	public void setmDate(Timestamp mDate) {
		this.mDate = mDate;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public int getmHit() {
		return mHit;
	}

	public void setmHit(int mHit) {
		this.mHit = mHit;
	}

	public String getmFile() {
		return mFile;
	}

	public void setmFile(String mFile) {
		this.mFile = mFile;
	}
	
}
