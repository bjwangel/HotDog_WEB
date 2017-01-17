package com.hotdog.petcam.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotdog.petcam.MailCheck.SendMail;
import com.hotdog.petcam.Repository.UserDao;
import com.hotdog.petcam.VO.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void login(UserVo userVo){
		
	}
	
	public void join(UserVo userVo){
		userDao.join(userVo);
	}
	
	public void sendCode(String email,int code){
		SendMail sendMail = new SendMail();
		sendMail.sendMail(email, code);
	}
}
