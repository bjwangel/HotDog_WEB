package com.hotdog.petcam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotdog.petcam.Repository.PostDao;
import com.hotdog.petcam.VO.PostVo;

@Service
public class PostService {

	@Autowired private PostDao postDao;
	
	
	public List<PostVo> getBlogMainPostList(String year,String month){
		
		// 첫 입장시 최근 글을 보여주기 위해 Dao 의 default list 를 가져오기위한 메서드를 호출한다. 
		if(year==null && month ==null){
			return postDao.getDefaultBlogMainPostList();
		}
		// 날짜 선택씨 주어진 변수로 리스트를 가져온다.
		return postDao.getBlogMainPostList(year, month);
	}
	
}
