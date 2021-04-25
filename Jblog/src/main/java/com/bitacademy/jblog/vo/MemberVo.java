package com.bitacademy.jblog.vo;

import java.util.Date;

public class MemberVo {

	private Long userNo;
	private String id;
	private String userName;
	private String passWord;
	private Date joinDate;
	
	
	
	public MemberVo() {
	
	}



	public MemberVo(Long userNo, String id, String userName, String passWord, Date joinDate) {
	
		this.userNo = userNo;
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.joinDate = joinDate;
	}



	public Long getUserNo() {
		return userNo;
	}



	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassWord() {
		return passWord;
	}



	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}



	public Date getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}



	@Override
	public String toString() {
		return "MemberVo [userNo=" + userNo + ", id=" + id + ", userName=" + userName + ", passWord=" + passWord
				+ ", joinDate=" + joinDate + "]";
	}
	
	
	
	
}
