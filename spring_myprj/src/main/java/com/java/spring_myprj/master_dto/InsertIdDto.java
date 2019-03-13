package com.java.spring_myprj.master_dto;

public class InsertIdDto {
	private String userId;

	public InsertIdDto() {
	}
	
	public InsertIdDto(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
