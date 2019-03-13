package com.java.spring_myprj.master_dto;

public class MpDto {
	private String masterId;
	private String masterPw;
	
	public MpDto(String masterId, String masterPw) {
		super();
		this.masterId = masterId;
		this.masterPw = masterPw;
	}
	
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getMasterPw() {
		return masterPw;
	}
	public void setMasterPw(String masterPw) {
		this.masterPw = masterPw;
	}
	
}
