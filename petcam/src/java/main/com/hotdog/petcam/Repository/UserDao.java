package com.hotdog.petcam.Repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotdog.petcam.VO.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
//	public void join(UserVo userVo){
//		sqlSession.insert("user.join", userVo);
//	}
//	
}
