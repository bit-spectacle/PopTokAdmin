package com.poptok.admin.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poptok.admin.util.PageParam;
import com.poptok.admin.vo.LocationInfoVo;

@Repository
public class PostingDao {

	@Autowired
	private SqlSession sqlSession;

	public List<LocationInfoVo> getLocationlist(PageParam pageParam) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("nowPage", pageParam.getNowPage());
		map.put("pageSize", pageParam.getPageSize());
		map.put("searchOption", pageParam.getSearchOption());
		map.put("searchText", pageParam.getSearchText());

		List<LocationInfoVo> list = sqlSession.selectList("posting.getLocationlist", map);
		int totalCount = Integer.parseInt(map.get("totalCount").toString());
		pageParam.setTotalCount(totalCount);
		return list;
	}
}
