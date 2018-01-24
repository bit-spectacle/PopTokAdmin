package com.poptok.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poptok.admin.repository.UserDao;
import com.poptok.admin.util.PageParam;
import com.poptok.admin.vo.StatisticsVo;
import com.poptok.admin.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	
	// 대시보드(가입자 통계 추출)
	public StatisticsVo getDashboard() {
		return userDao.getDashboard();
	}
	
	public UserVo getUser(String email, String password) {
		UserVo userVo = userDao.get(email, password);
		return userVo;
	}
	
	// 사용자 / 관리자
	public List<UserVo> getUserlist(PageParam pageParam) {
		return userDao.getUserlist(pageParam);
	}

}
