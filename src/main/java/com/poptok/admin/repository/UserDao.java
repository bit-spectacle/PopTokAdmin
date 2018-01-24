package com.poptok.admin.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poptok.admin.util.PageParam;
import com.poptok.admin.vo.StatisticsVo;
import com.poptok.admin.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 대시보드(가입자 통계)
	public StatisticsVo getDashboard() {
		StatisticsVo result = sqlSession.selectOne("user.getDashboard");
		return result;
	}
	
	
	public UserVo get( String email, String password ) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password", password);
		UserVo vo = sqlSession.selectOne("user.getByEmailAndPassword", map);
		
		return vo;
	}

	
	// 사용자/관리자 목록
	public List<UserVo> getUserlist(PageParam pageParam) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("nowPage", pageParam.getNowPage());
		map.put("pageSize", pageParam.getPageSize());
		map.put("searchOption", pageParam.getSearchOption());
		map.put("searchText", pageParam.getSearchText());
		map.put("optParam", pageParam.getOptParam()==null?"":pageParam.getOptParam());
		map.put("orderBy", pageParam.getOrderBy()==null?"":pageParam.getOrderBy());
		
		List<UserVo> list = sqlSession.selectList("user.getUserlist", map);
		int totalCount = Integer.parseInt(map.get("totalCount").toString());
		pageParam.setTotalCount(totalCount);
		
		
		return list;
	}

	
}
