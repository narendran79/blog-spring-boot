package com.example.Blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog.Model.UserInfo;
import com.example.Blog.Repository.UserInfoRepository;
import com.example.Blog.Service.UserInfoService;


@RestController
@RequestMapping("/api/user")
public class UserInfoController {

	@Autowired
	private UserInfoRepository userinfo;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping()
	public List<UserInfo> getAllUsers() {
	     return this.userinfo.findAll();
	}

		@PostMapping("/save")
		public String saveUser(@RequestBody UserInfo userInfo) {
			userInfoService.saveUser(userInfo);
			return "user saved";
		}
}

