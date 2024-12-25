package com.example.Blog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Blog.Model.UserInfo;
import com.example.Blog.Repository.UserInfoRepository;


@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userinfo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public UserInfo saveUser(UserInfo userInfo) {
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		return userinfo.save(userInfo);
	}
}
