package com.bitacademy.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.exception.MemberDaoException;
import com.bitacademy.jblog.vo.MemberVo;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	private static Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVo vo) {
		
		int insertedCount = 0;
		
		try {
			insertedCount = sqlSession.insert("members.insert", vo);
		} catch  (Exception e) {
			logger.error("예외 발생:" + e.getMessage());																								
			throw new MemberDaoException("회원 가입 중 오류 발생!", vo);
		}
		return insertedCount;
	}

	@Override
	public MemberVo selectUser(String id, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("id",id);
		userMap.put("password",password);
		MemberVo vo = sqlSession.selectOne("members.selectUserByNameAndPassword", userMap);
		return vo;
	}

	@Override
	public MemberVo selectUser(String id) {
		
		MemberVo vo = sqlSession.selectOne("members.selectUserById", id);
		return vo;
	}

}
