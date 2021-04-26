package com.bitacademy.jblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.jblog.service.MemberService;
import com.bitacademy.jblog.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	// 서비스 연결
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = { "", "/", "/join" }, method = RequestMethod.GET)
	public String join(@ModelAttribute MemberVo memberVo) {
		return "users/joinform";
	}
}
