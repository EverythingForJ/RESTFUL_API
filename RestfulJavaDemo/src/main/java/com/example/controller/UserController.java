package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

@Controller
public class UserController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String main() {
		return "index"; // /static/index.html
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	@ResponseBody
	public Map read() {
		List<MemberVO> list = this.memberService.select();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		map.put("data", list);
		return map;
	}
	
//	@RequestMapping(value = "/members/{userid}", method = RequestMethod.GET)
//	@ResponseBody
//	public Map read(@PathVariable String userid) {
//		List<MemberVO> member = this.memberService.selectMember(userid);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("code", "success");
//		map.put("data", member);
//		return map;
//	}
	
}
