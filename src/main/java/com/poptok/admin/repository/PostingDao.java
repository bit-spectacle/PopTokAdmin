package com.poptok.admin.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poptok.admin.util.PageParam;
import com.poptok.admin.vo.LocationInfoVo;
import com.poptok.admin.vo.PostVo;
import com.poptok.admin.vo.StatisticsVo;
import com.poptok.admin.vo.UserVo;

@Repository
public class PostingDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 대시보드(포스팅 통계)
	public StatisticsVo getDashboard() {
		StatisticsVo result = sqlSession.selectOne("posting.getDashboard");
		return result;
	}
	

	public List<LocationInfoVo> getLocationlist(PageParam pageParam) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("nowPage", pageParam.getNowPage());
		map.put("pageSize", pageParam.getPageSize());
		map.put("searchOption", pageParam.getSearchOption());
		map.put("searchText", pageParam.getSearchText());
		map.put("optParam", pageParam.getOptParam()==null?"":pageParam.getOptParam());
		map.put("orderBy", pageParam.getOrderBy()==null?"":pageParam.getOrderBy());
		
		List<LocationInfoVo> list = sqlSession.selectList("posting.getLocationlist", map);
		int totalCount = Integer.parseInt(map.get("totalCount").toString());
		pageParam.setTotalCount(totalCount);
		return list;
	}
	
	
	public List<PostVo> getPostlist(PageParam pageParam) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("nowPage", pageParam.getNowPage());
		map.put("pageSize", pageParam.getPageSize());
		map.put("searchOption", pageParam.getSearchOption());
		map.put("searchText", pageParam.getSearchText());
		map.put("optParam", pageParam.getOptParam()==null?"":pageParam.getOptParam());
		map.put("orderBy", pageParam.getOrderBy()==null?"":pageParam.getOrderBy());
		
		List<PostVo> list = sqlSession.selectList("posting.getPostlist", map);
		int totalCount = Integer.parseInt(map.get("totalCount").toString());
		pageParam.setTotalCount(totalCount);
		return list;
	}
	
	public List<String> getPostTagList() {
		List<String> list = sqlSession.selectList("posting.getPostTagList");
		return list;
	}

}
