package com.bitacademy.jblog.exception;

import com.bitacademy.jblog.vo.MemberVo;

public class MemberDaoException extends RuntimeException {

private MemberVo memberVo = null;
	
	//	생성자
	public MemberDaoException() {
		
	}
	
	public MemberDaoException(String message) {
		super(message);
	}
	
	public MemberDaoException(String message, MemberVo memberVo) {
		super(message);
		this.memberVo = memberVo;
	}

	//	Getter / Setter
	public MemberVo getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}
	
}
