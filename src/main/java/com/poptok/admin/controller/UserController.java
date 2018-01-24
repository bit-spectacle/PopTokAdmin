package com.poptok.admin.controller;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poptok.admin.service.UserService;
import com.poptok.admin.util.OtherParam;
import com.poptok.admin.util.PageParam;
import com.poptok.admin.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Log LOG = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	

	@RequestMapping("list")
	public String userList() {
		
		return "user/list";
	}
	
	
	// 사용자/관리자
	@RequestMapping("user")
	public String user(@ModelAttribute PageParam pageParam, Model model) 
	{
		System.out.println(pageParam);
		//pageParam = new PageParam(1, 10, "newAddress", "영등포");
		
		List<UserVo> list = userService.getUserlist(pageParam);
		model.addAttribute("list", list);
		model.addAttribute("pageParam", pageParam);

		return "user/user";
	}

}
