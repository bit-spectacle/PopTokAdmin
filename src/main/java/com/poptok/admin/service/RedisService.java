package com.poptok.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import com.poptok.admin.vo.TagVo;

@Service
public class RedisService {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Resource(name="redisTemplate")
	private ZSetOperations<String, String> zsetOperations;
	
	String tagKey = "poptok_tag";
	
	
	public List<TagVo> tagList() {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		
		Set<ZSetOperations.TypedTuple<String>> set = zsetOperations.reverseRangeWithScores(tagKey, 0, 100);
		List<TagVo> list = new ArrayList<>(set.size());
		for(ZSetOperations.TypedTuple<String> vo : set ) {
			String tag = vo.getValue();
			int count = (int)Math.round(vo.getScore());
			
			TagVo tagVo = new TagVo();
			tagVo.setTag(tag);
			tagVo.setCount(count);
			
			list.add(tagVo);
		}
		return list;
	}


	public void AddTag(String tag, int count) {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		zsetOperations.add(tagKey, tag, count);
	}

}
