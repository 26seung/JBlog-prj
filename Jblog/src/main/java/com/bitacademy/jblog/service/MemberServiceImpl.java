package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.MemberDao;
import com.bitacademy.jblog.vo.MemberVo;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	public boolean join(MemberVo vo) {
		
		int insertedCount = memberDao.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public MemberVo getUser(String id, String password) {
		MemberVo vo = memberDao.selectUser(id,password);
		return vo;
	}

	// 	id 중복 처리
	@Override
	public MemberVo getUser(String id) {
		MemberVo vo = memberDao.selectUser(id);
		return vo;
	}


}
