package com.poptok.admin.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poptok.admin.service.PostingService;
import com.poptok.admin.util.PageParam;
import com.poptok.admin.vo.LocationInfoVo;
import com.poptok.admin.vo.PostVo;

@Controller
@RequestMapping("/posting")
public class PostingController {
	private static final Log LOG = LogFactory.getLog(UserController.class);
	
	@Autowired
	private PostingService postingService;
	
	// 장소
	@RequestMapping("location")
	public String location(@ModelAttribute PageParam pageParam, Model model) {
		
		System.out.println(pageParam);
		//pageParam = new PageParam(1, 10, "newAddress", "영등포");
		
		List<LocationInfoVo> list = postingService.getLocationlist(pageParam);
		model.addAttribute("list", list);
		model.addAttribute("pageParam", pageParam);
		
		return "posting/location";
	}
	
	// 포스트
	@RequestMapping("post")
	public String post(@ModelAttribute PageParam pageParam, Model model) {

		System.out.println(pageParam);
		//pageParam = new PageParam(1, 10, "newAddress", "영등포");
		
		List<PostVo> list = postingService.getPostlist(pageParam);
		model.addAttribute("list", list);
		model.addAttribute("pageParam", pageParam);
		
		return "posting/post";
	}
	
	
}
