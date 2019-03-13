package com.java.spring_myprj.favideo.dto;

import java.sql.Timestamp;

public class vDto {
	
	private String userId;
	private Timestamp vDate;
	private int vNum;
	private int vHit;
	private String vAddr;
	private String vTitle;
	private String vContent;
	private String userInterests;
	private String vReview;
	private String vImage;
	
	
	public vDto() {
	}
	
	public vDto(String userId, Timestamp vDate, int vNum, int vHit, String vAddr, String vTitle, String vContent,
			String userInterests, String vReview, String vImage) {
		this.userId = userId;
		this.vDate = vDate;
		this.vNum = vNum;
		this.vHit = vHit;
		this.vAddr = vAddr;
		this.vTitle = vTitle;
		this.vContent = vContent;
		this.userInterests = userInterests;
		this.vReview = vReview;
		this.vImage = vImage;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getvDate() {
		return vDate;
	}
	public void setvDate(Timestamp vDate) {
		this.vDate = vDate;
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
