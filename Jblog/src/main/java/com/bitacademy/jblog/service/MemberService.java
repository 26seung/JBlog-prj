package com.bitacademy.jblog.service;

import com.bitacademy.jblog.vo.MemberVo;

public interface MemberService {
	
	public boolean join(MemberVo vo);	//	가입(INSERT)
	public MemberVo getUser(String email, String password);	//	로그인용
	public MemberVo getUser(String email);	//	중복 이메일 체크용
}
