package com.hotdog.petcam.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotdog.petcam.Repository.BlogDao;

@Service
public class BlogService {
	
	@Autowired private BlogDao blogDao;
	
	
	
}
