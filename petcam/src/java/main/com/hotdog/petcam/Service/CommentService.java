package com.hotdog.petcam.Service;

import org.springframework.stereotype.Service;

// board_comment , post_comment 테이블을 모두 관리
@Service
public class CommentService {

	@Autowired 
	private CommentDao commentDao
}
