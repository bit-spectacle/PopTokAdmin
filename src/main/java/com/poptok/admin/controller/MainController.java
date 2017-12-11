package com.poptok.admin.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poptok.admin.security.Auth;
import com.poptok.admin.service.CategoryService;

@Controller
@RequestMapping("/")
@Auth(role=Auth.Role.ADMIN)
public class MainController {
	
	private static final Log LOG = LogFactory.getLog( MainController.class );
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("hello")
	public ModelAndView hello() {
		System.out.println("hello");
		ModelAndView mav = new ModelAndView();
		mav.addObject( "hello", "Hello " );
		mav.setViewName( "index" );
		
		return mav;
	}
	
	@RequestMapping("")
	public String index(ModelMap model) {
		System.out.println("index");
		int count = categoryService.getCount();
		System.out.println("count:" + count);
		LOG.debug("count:" + count);
		//model.addAttribute("title", "test");
		return "main/index";
	}
	
//	@RequestMapping("")
//	public ModelAndView index() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject( "title", "Hello test" );
//		mav.setViewName( "main/index" );
//		
//		return mav;
//	}
}
