package com.hotdog.petcam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotdog.petcam.Repository.CommentDao;
import com.hotdog.petcam.VO.BoardCommentVo;
import com.hotdog.petcam.VO.PostCommentVo;

// board_comment , post_comment 테이블을 모두 관리
@Service
public class CommentService {

	@Autowired 
	private CommentDao commentDao;
	
	// *************  게시판 관련    ************
	// 게시글 뷰에서 댓글 가져오기
	public List<BoardCommentVo> getBoardComment(int board_no){
		return commentDao.getBoardComment(board_no);
	}
	
	
	
	
	// **************   블로그 관련	 ***********
	
	// Blog 메인 포스트에 뿌릴 댓글 리스트 가져오기
	public List<PostCommentVo> getBlogMainCommentList(String year,String month){
		
		if( year ==null && month== null){
			return commentDao.getDefaultBlogMainCommentList();
		}
		
		return commentDao.getBlogMainCommentList(year,month);
	}
}
