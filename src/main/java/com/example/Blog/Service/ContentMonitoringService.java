package com.example.Blog.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Blog.Model.Blog;
import com.example.Blog.Repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentMonitoringService {
	
	@Autowired
	public BlogRepository blogRepository;
	
	public Blog getContentHighlight(Integer blogId) {
		Blog blog = blogRepository.findById(blogId).orElse(null);
		
		if (blog != null) {
			String content = blog.getContent();
			
			
			String highlightedContent = content.replaceAll("(\\bhumans\\b|\\bdo\\b)", "[warn]$1[warn]");
			
			blog.setContent(highlightedContent);
			blogRepository.save(blog);
		}
		
		return blog;
	}
}
