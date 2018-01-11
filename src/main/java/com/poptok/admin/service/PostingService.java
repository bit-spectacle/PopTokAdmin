package com.poptok.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poptok.admin.repository.PostingDao;
import com.poptok.admin.util.PageParam;
import com.poptok.admin.vo.LocationInfoVo;
import com.poptok.admin.vo.PostVo;

@Service
public class PostingService {
	
	@Autowired
	private PostingDao postingDao;
	
	public List<LocationInfoVo> getLocationlist(PageParam pageParam) {
		return postingDao.getLocationlist(pageParam);
	}

	
	public List<PostVo> getPostlist(PageParam pageParam) {
		return postingDao.getPostlist(pageParam);
	}
}
