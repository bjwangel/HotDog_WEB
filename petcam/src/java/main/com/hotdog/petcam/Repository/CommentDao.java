package com.hotdog.petcam.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotdog.petcam.VO.BoardCommentVo;

@Repository
public class CommentDao {

	@Autowired 
	private SqlSession sqlSession;
	
	// 게시판 글의 댓글을 가져온다.
	public List<BoardCommentVo> getBoardComment(int board_no){
		return sqlSession.selectList("comment.getBoardComment",board_no);
	}
}
