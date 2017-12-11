package com.poptok.admin.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int getCount() {
		System.out.println("getCount");
		int totalCount = sqlSession.selectOne("category.getCount");
		return totalCount;
	}
}
