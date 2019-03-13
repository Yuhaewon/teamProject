package com.java.spring_myprj.login_dto;

import java.sql.Timestamp;

public class LoginDto {
	private int count;
	private String userId;
	private String userPw;
	private String eMail;
	private String userGender;
	private String userIden;
	private String userAddr;
	private String userPwhint;
	private Timestamp userJoin;
	private String userInterests;
	private int userNum;
	private String userNick;
	private String userName;
	private String userPwCheck;
	private String userPhone;
	private String userpWhintList;
	
	public LoginDto() {
	}

	public LoginDto(String userId, String userPw, String eMail, String userGender, String userIden, String userAddr,
			String userPwhint, Timestamp userJoin, String userInterests, int userNum, String userNick, String userName,
			String userPwCheck, String userPhone, String userpWhintList) {
		this.userId = userId;
		this.userPw = userPw;
		this.eMail = eMail;
		this.userGender = userGender;
		this.userIden = userIden;
		this.userAddr = userAddr;
		this.userPwhint = userPwhint;
		this.userJoin = userJoin;
		this.userInterests = userInterests;
		this.userNum = userNum;
		this.userNick = userNick;
		this.userName = userName;
		this.userPwCheck = userPwCheck;
		this.userPhone = userPhone;
		this.userpWhintList = userpWhintList;
	}

	
	public LoginDto(int count) {
		this.count =count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserIden() {
		return userIden;
	}

	public void setUserIden(String userIden) {
		this.userIden = userIden;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserPwhint() {
		return userPwhint;
	}

	public void setUserPwhint(String userPwhint) {
		this.userPwhint = userPwhint;
	}

	public Timestamp getUserJoin() {
		return userJoin;
	}

	public void setUserJoin(Timestamp userJoin) {
		this.userJoin = userJoin;
	}

	public String getUserInterests() {
		return userInterests;
	}

	public void setUserInterests(String userInterests) {
		this.userInterests = userInterests;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwCheck() {
		return userPwCheck;
	}

	public void setUserPwCheck(String userPwCheck) {
		this.userPwCheck = userPwCheck;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserpWhintList() {
		return userpWhintList;
	}

	public void setUserpWhintList(String userpWhintList) {
		this.userpWhintList = userpWhintList;
	}

	
	
	
}