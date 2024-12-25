package com.example.Blog.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Blog.Exception.ResourceNotFound;
import com.example.Blog.Model.UserInfo;
import com.example.Blog.Repository.UserInfoRepository;
import com.example.Blog.dto.UserInfoUserDeatil;


public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = userInfoRepo.findByUsername(username);
		return userInfo.map(UserInfoUserDeatil::new).orElseThrow(() -> new ResourceNotFound("customer_id is not exsists"));
	}

} 


