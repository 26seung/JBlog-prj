package com.bitacademy.jblog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.jblog.service.MemberService;
import com.bitacademy.jblog.vo.MemberVo;

@Controller
@RequestMapping("/members")
public class MemberController {

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	// 서비스 연결
	@Autowired
	private MemberService memberService;
	
	// 회원가입 창 연결
	@RequestMapping(value = { "", "/", "/join" }, method = RequestMethod.GET)
	public String join(@ModelAttribute MemberVo memberVo) {
		return "users/joinform";
	}	
	
	// 회원가입 처리
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(@ModelAttribute MemberVo memberVo) {
		boolean success = memberService.join(memberVo);
		
		if(success) {
			logger.debug("가입 성공!");
			return "redirect:/members/joinsuccess";
		}else {
			logger.error("가입 실패!");
			return "redirect:/members/";
		}		
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}
	
	@ResponseBody
	@RequestMapping("/idcheck")
	public Object existsId(@RequestParam(value="id", required = false, defaultValue = "")String id) {
		MemberVo vo = memberService.getUser(id);
		boolean exists = vo != null ? true:false;			//	vo 객체가 null -> 이미 존재하는 사용자
			
		// 결과 MAP   -> 컨버터 -> JSON 변환			
		Map<String, Object>map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
			
		return map;
	}
	
	// 로그인 연결
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "users/loginform";		
	}
	
	// 로그인 처리
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(@RequestParam String id,@RequestParam String password,  HttpSession session ) {
		MemberVo authUser = memberService.getUser(id, password);
		
		if(authUser!=null) {
			session.setAttribute("authUser", authUser);
			// 홈페이지로 리다이렉트
			return "redirect:/";
		}else {
			// 로그인 실패
			return "redirect:/members/login";
		}
	}
		
	// 로그아웃 처리
	@RequestMapping("/logout")
	public String logoutAction(HttpSession session) {
		// 세션 지우기
		session.removeAttribute("authUser");
		// 세션 무효화
		session.invalidate();
		return "redirect:/";
	}
	
}
