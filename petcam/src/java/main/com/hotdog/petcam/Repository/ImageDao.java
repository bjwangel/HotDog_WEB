package com.hotdog.petcam.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotdog.petcam.VO.Post_imageVo;

@Repository
public class ImageDao {

	@Autowired private SqlSession sqlSession;
	
	
	// ************ 블로그 메인화면 이미지 리스트 가져오기  , Post_imageVo 반환  ***************
	
	public List<Post_imageVo>getBlogMainImageList(String year,String month){
		
		Map<String,String> date= new HashMap<String,String>();
		date.put("year", year);
		date.put("month", month);
		
		return sqlSession.selectList("image.getBlogMainImageList", date);
	}
	
	public List<Post_imageVo>getDefaultBlogMainImageList(){
		
		return sqlSession.selectList("image.getDefaultBlogMainImageList");
	}
}
