package com.hotdog.petcam.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotdog.petcam.Repository.AccountDao;

@Service
public class AccountService {

	@Autowired 
	private AccountDao accountDao;
}
