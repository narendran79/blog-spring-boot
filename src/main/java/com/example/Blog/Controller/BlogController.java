package com.example.Blog.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog.Exception.ResourceNotFound;
import com.example.Blog.Model.Blog;
import com.example.Blog.Repository.BlogRepository;
import com.example.Blog.Service.BlogViewService;
import com.example.Blog.Service.ContentMonitoringService;





@RestController
@RequestMapping("/api/blog")
public class BlogController {
	
	

	
	@Autowired
	public BlogRepository blogrepository;
	
	@Autowired
	public BlogViewService viewService;
	
	@Autowired
	public ContentMonitoringService contentMonitoring;
	

	@GetMapping("/getAllBlog")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Blog> getBlogdetail() {
		return this.blogrepository.findAll();
	}
	
	
	@PostMapping("/createBlog")
	public Blog createBlog(@RequestBody Blog blog) {
		return this.blogrepository.save(blog);
	}
	
	@GetMapping("/findBlog/{id}")
	@PreAuthorize("hasAuthority('ROLE_AUTHOR')")
	public Blog getBlogById(@PathVariable(value="id")Integer blogId) {
		return this.blogrepository.findById(blogId)
				.orElseThrow(() -> new ResourceNotFound("Blog is not exsists"));

	}
	
	@PutMapping("/updateBlog/{id}")
	@PreAuthorize("hasAuthority('ROLE_AUTHOR')")
	public Blog updateBlog(@RequestBody Blog blog, @PathVariable(value = "id") Integer blogId) {
	    Optional<Blog> optionalAdmin = this.blogrepository.findById(blogId);
	    if(optionalAdmin.isPresent()) {
	    	this.blogrepository.save(blog);
	    	return blog;
	    }else {
	    	throw new ResourceNotFound("Blog doesn't exsists" );
	    }
	}
	
	@DeleteMapping("/deleteBlog/{id}")
	@PreAuthorize("hasAuthority('ROLE_AUTHOR')")
	public Blog deleteBlog(@RequestBody Blog blog, @PathVariable(value = "id") Integer blogId) {
	    Optional<Blog> optionalBlog = this.blogrepository.findById(blogId);
	    if(optionalBlog.isPresent()) {
	    	this.blogrepository.delete(blog);
	    	return blog;
	    }else {
	    	throw new ResourceNotFound("Blog doesn't exsists" );
	    }
	}
	
	 @GetMapping("/viewBlog/{id}")
	 public Optional<Blog> incrementView(@PathVariable(value = "id") Integer blogId) {
	        return viewService.incrementView(blogId);
	    }
	 
	 
	 @GetMapping("/title")
	    public ResponseEntity<List<Blog>> findByTitle(@RequestParam String title)
	    {
		 return new  ResponseEntity<List<Blog>>(blogrepository.findByTitle(title),HttpStatus.OK);
	    }
	 
	 @GetMapping("/authorId")
	    public ResponseEntity<List<Blog>> findByAuthorId(@RequestParam Integer authorId)
	    {
		 return new  ResponseEntity<List<Blog>>(blogrepository.findByAuthorId(authorId),HttpStatus.OK);
	    }

	 
	 @PostMapping("/content/{id}")
	 public Blog contentMonitor(@PathVariable(value="id") Integer blogId) {
		 return contentMonitoring.getContentHighlight(blogId);
	 }
	 
}
