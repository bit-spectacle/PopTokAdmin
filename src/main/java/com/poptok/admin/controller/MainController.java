package com.poptok.admin.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poptok.admin.security.Auth;
import com.poptok.admin.service.CategoryService;
import com.poptok.admin.service.PostingService;
import com.poptok.admin.service.UserService;
import com.poptok.admin.util.PageParam;
import com.poptok.admin.vo.PostVo;
import com.poptok.admin.vo.StatisticsVo;
import com.poptok.admin.vo.UserVo;

@Controller
@RequestMapping("")
@Auth(role=Auth.Role.ADMIN)
public class MainController {
	
	private static final Log LOG = LogFactory.getLog( MainController.class );
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private PostingService postingService;
	

	@RequestMapping("hello")
	public ModelAndView hello() {
		System.out.println("hello");
		ModelAndView mav = new ModelAndView();
		mav.addObject( "hello", "Hello " );
		mav.setViewName( "index" );
		
		return mav;
	}
	
	/*
	@RequestMapping("")
	public String index(ModelMap model) {
		System.out.println("index");
		int count = categoryService.getCount();
		System.out.println("count:" + count);
		LOG.debug("count:" + count);
		//model.addAttribute("title", "test");
		return "main/index";
	}
	*/
//	@RequestMapping("")
//	public ModelAndView index() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject( "title", "Hello test" );
//		mav.setViewName( "main/index" );
//		
//		return mav;
//	}
	
	// DashBoard
	//@RequestMapping("")
	public String dashboard2(Model model) {
		
		// 상단 가입자/포스팅 통계 부분
		StatisticsVo uStt = userService.getDashboard();
		StatisticsVo pStt = postingService.getDashboard();
		
		// 하단 가입자/포스팅 최근 5개 목록
		PageParam pageParam = new PageParam("1", "5", "", "", "", "DESC");
		System.out.println(pageParam);
		List<UserVo> ulist = userService.getUserlist(pageParam);
		List<PostVo> plist = postingService.getPostlist(pageParam);
		
		model.addAttribute("uStt", uStt);
		model.addAttribute("pStt", pStt);
		model.addAttribute("ulist", ulist);
		model.addAttribute("plist", plist);

		return "index";
	}
	
	// DashBoard
	@RequestMapping("")
	public ModelAndView dashboard() {
		
		// 상단 가입자/포스팅 통계 부분
		StatisticsVo uStt = userService.getDashboard();
		StatisticsVo pStt = postingService.getDashboard();
		
		// 하단 가입자/포스팅 최근 5개 목록
		PageParam pageParam = new PageParam("1", "5", "", "", "", "DESC");
		System.out.println(pageParam);
		List<UserVo> ulist = userService.getUserlist(pageParam);
		List<PostVo> plist = postingService.getPostlist(pageParam);
		System.out.println("ulist=============================");
		System.out.println(ulist);
		System.out.println("plist=============================");
		System.out.println(plist);
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("uStt", uStt);
		mav.addObject("pStt", pStt);
		mav.addObject("ulist", ulist);
		mav.addObject("plist", plist);
		mav.setViewName( "main/index" );
		System.out.println("=============================");
		System.out.println(mav);
		
		return mav;
	}
	
}
