package com.hotdog.petcam.Repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

	@Autowired 
	private SqlSession sqlSession;
}
