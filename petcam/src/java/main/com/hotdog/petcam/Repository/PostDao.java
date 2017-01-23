package com.hotdog.petcam.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotdog.petcam.VO.PostVo;

@Repository
public class PostDao {

	@Autowired private SqlSession sqlSession;
	
	public List<PostVo> getBlogMainPostList(String year,String month){
		// DB 에서 꺼내오려면  변수들을 String 하나로 묶어서 보내야하나..?
		
		Map<String,String> date = new HashMap<String,String>();
		date.put("year", year);
		date.put("month", month);
		
		return sqlSession.selectList("post.getBlogMainPost", date);
	}
	
	public List<PostVo> getDefaultBlogMainPostList(){
		return sqlSession.selectList("post.getDefaultMainPostList");
	}
}
