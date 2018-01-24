package com.poptok.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poptok.admin.repository.PostingDao;
import com.poptok.admin.util.PageParam;
import com.poptok.admin.vo.LocationInfoVo;
import com.poptok.admin.vo.PostVo;
import com.poptok.admin.vo.StatisticsVo;

@Service
public class PostingService {
	
	@Autowired
	private PostingDao postingDao;
	
	// 대시보드(포스팅 통계 추출)
	public StatisticsVo getDashboard() {
		return postingDao.getDashboard();
	}
	
	
	public List<LocationInfoVo> getLocationlist(PageParam pageParam) {
		return postingDao.getLocationlist(pageParam);
	}

	
	public List<PostVo> getPostlist(PageParam pageParam) {
		return postingDao.getPostlist(pageParam);
	}
	

}
