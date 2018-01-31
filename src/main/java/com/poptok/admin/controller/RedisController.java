package com.poptok.admin.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poptok.admin.security.Auth;
import com.poptok.admin.service.PostingService;
import com.poptok.admin.service.RedisService;
import com.poptok.admin.vo.TagVo;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
@RequestMapping("/redis")
@Auth(role=Auth.Role.ADMIN)
public class RedisController {
	
	private static final Log LOG = LogFactory.getLog( RedisController.class );
	
	@Autowired
	private RedisService redisService;
	
	@Autowired
	private PostingService postingService;
	
	@RequestMapping("client")
	public String client(Model model) {
		LOG.debug("client");
		
		List<TagVo> list = redisService.tagList();
		
		model.addAttribute( "tagList", list);
		
		return "redis/client";
	}
	
	@RequestMapping("init")
	public String init(Model model) {
//		String tags = "#강, #강다니엘, #다니엘, #녜, #녜리, #리\r\n" + 
//				"#완전, #리얼, #대박, #강, #강다니엘, #다니엘, #녤뭉\r\n" + 
//				"#강, #강다니엘, #다니엘, #콘서트, #축하\r\n" + 
//				"#인원, #인원중, #중, #강, #강다니엘, #다니엘, #눈, #ㅠ, #강단";
		List<String> list = postingService.getPostTagList();
		String tags = String.join("", list);
		tags = tags.replaceAll("#", "").replaceAll(" ", "");
		List<String> taglist = Arrays.asList(tags.split(","));
		
		Map<Object, Long> nameCount = taglist.stream().collect(Collectors.groupingBy(string -> string, Collectors.counting()));
		nameCount.forEach((name, count) -> {
			if(name != null && name != "") {
				redisService.AddTag(name.toString(), Integer.parseInt(count.toString()));
			}
        });
		
		return "redirect:/redis/client";
	}

	
	@RequestMapping("blank")
	public String blank(Model model) {
		redisService.blankTag();
		
		return "redirect:/redis/client";
	}
	
	
	@RequestMapping("delete")
	public String delete(Model model) {
		boolean result = postingService.deletePostData("41712", "", "");
		
		String msg = "";
		if(result) msg = "삭제되었습니다.";
		else msg = "실패하였습니다.";
		model.addAttribute( "deleteResult", msg);
		
		return "redis/client";
	}
}
