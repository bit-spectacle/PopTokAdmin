package com.poptok.admin.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.poptok.admin.service.UserService;
import com.poptok.admin.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		UserService userService = ac.getBean(UserService.class);
		UserVo userVo = userService.getUser(email, password);
		if(userVo == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		//세션 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userVo);
		response.sendRedirect(request.getContextPath());
		return false;
	}

}
