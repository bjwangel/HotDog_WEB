package com.hotdog.petcam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotdog.petcam.Repository.ImageDao;
import com.hotdog.petcam.VO.Post_imageVo;

@Service
public class ImageService {
	@Autowired private ImageDao imageDao;
	
	public List<Post_imageVo> getBlogMainImageList(String year,String month){
		if(year==null && month==null ){
			return imageDao.getDefaultBlogMainImageList();
		}
		
		return imageDao.getBlogMainImageList(year,month);
	}
}
