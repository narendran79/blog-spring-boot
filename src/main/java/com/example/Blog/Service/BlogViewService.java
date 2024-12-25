package com.example.Blog.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Blog.Exception.ResourceNotFound;
import com.example.Blog.Model.Blog;
import com.example.Blog.Repository.BlogRepository;

@Service
public class BlogViewService {

	@Autowired
    private BlogRepository blogRepository;

    public Optional<Blog> incrementView(Integer blogId) {
        Optional<Blog> blogOptional = blogRepository.findById(blogId);

        if (blogOptional.isPresent()) {
            Blog blog = blogOptional.get();
            int currentViews = blog.getViews();
            blog.setViews(currentViews + 1);
            blogRepository.save(blog);
            
        }else {
        	throw new ResourceNotFound("Blog doesn't exsists" );
	    }
		return blogOptional;
	}
}

