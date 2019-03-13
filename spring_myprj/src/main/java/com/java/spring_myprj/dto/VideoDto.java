package com.java.spring_myprj.dto;

import java.sql.Timestamp;

public class VideoDto {
	private int vNum;
	private int vHit;
	private Timestamp vDate;
	private String userId;
	private String vAddr;
	private String vTitle;
	private String vContent;
	private String userInterests;
	private String vReview;
	private String vImage;
	
	private String wFile;
	
	public VideoDto() {
	}

	public VideoDto(int vNum, int vHit, Timestamp vDate, String userId, String vAddr, String vTitle, String vContent,
			String userInterests, String vReview, String vImage, String wFile) {
		this.vNum = vNum;
		this.vHit = vHit;
		this.vDate = vDate;
		this.userId = userId;
		this.vAddr = vAddr;
		this.vTitle = vTitle;
		this.vContent = vContent;
		this.userInterests = userInterests;
		this.vReview = vReview;
		this.vImage = vImage;
		this.wFile=wFile;
	}

	public VideoDto(int vNum2, int vHit2, Timestamp vDate2, String userId2, String vAddr2, String vTitle2,
			String vContent2, String userInterests2, String vReview2, String vImage2) {
		this.vNum = vNum2;
		this.vHit = vHit2;
		this.vDate = vDate2;
		this.userId = userId2;
		this.vAddr = vAddr2;
		this.vTitle = vTitle2;
		this.vContent = vContent2;
		this.userInterests = userInterests2;
		this.vReview = vReview2;
		this.vImage = vImage2;
	}

	public String getwFile() {
		return wFile;
	}

	public void setwFile(String wFile) {
		this.wFile = wFile;
	}

	public int getvNum() {
		return vNum;
	}

	public void setvNum(int vNum) {
		this.vNum = vNum;
	}

	public int getvHit() {
		return vHit;
	}

	public void setvHit(int vHit) {
		this.vHit = vHit;
	}

	public Timestamp getvDate() {
		return vDate;
	}

	public void setvDate(Timestamp vDate) {
		this.vDate = vDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getvAddr() {
		return vAddr;
	}

	public void setvAddr(String vAddr) {
		this.vAddr = vAddr;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public String getvContent() {
		return vContent;
	}

	public void setvContent(String vContent) {
		this.vContent = vContent;
	}

	public String getUserInterests() {
		return userInterests;
	}

	public void setUserInterests(String userInterests) {
		this.userInterests = userInterests;
	}

	public String getvReview() {
		return vReview;
	}

	public void setvReview(String vReview) {
		this.vReview = vReview;
	}

	public String getvImage() {
		return vImage;
	}

	public void setvImage(String vImage) {
		this.vImage = vImage;
	}
	
	
	
	

}
