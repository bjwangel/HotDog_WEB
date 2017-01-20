package com.hotdog.petcam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotdog.petcam.Repository.CommentDao;
import com.hotdog.petcam.VO.BoardCommentVo;

// board_comment , post_comment 테이블을 모두 관리
@Service
public class CommentService {

	@Autowired 
	private CommentDao commentDao;
	
	// 게시판에 보일 댓글 리스트를 가져온다.
	public List<BoardCommentVo> getBoardComment(int board_no){
		return commentDao.getBoardComment(board_no);
	}
}
