package com.poptok.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poptok.admin.repository.CategoryDao;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public int getCount() {
		return categoryDao.getCount();
	}
}
