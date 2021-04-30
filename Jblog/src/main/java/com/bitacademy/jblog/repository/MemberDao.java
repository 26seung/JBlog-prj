package com.bitacademy.jblog.repository;

import com.bitacademy.jblog.vo.MemberVo;

public interface MemberDao {

	public int insert(MemberVo vo);	//	INSERT
	public MemberVo selectUser(String id, String password);
	public MemberVo selectUser(String id);
}
