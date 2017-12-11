package com.poptok.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poptok.admin.repository.UserDao;
import com.poptok.admin.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public UserVo getUser(String email, String password) {
		UserVo userVo = userDao.get(email, password);
		return userVo;
	}
}
