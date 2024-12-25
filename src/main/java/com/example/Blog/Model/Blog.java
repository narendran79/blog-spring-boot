package com.example.Blog.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog_test")
public class Blog {

	@Id
	private Integer blogId;
	private String title;
	private String content;
	private String image;
	private   Integer views;
    private Integer authorId;
    
	
	public Blog() {
		
	}


	public Blog(Integer blogId, String title, String content, String image, Integer views, Integer authorId) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.content = content;
		this.image = image;
		this.views = views;
		this.authorId = authorId;
	}


	public Integer getBlogId() {
		return blogId;
	}


	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Integer getViews() {
		return views;
	}


	public void setViews(Integer views) {
		this.views = views;
	}


	public Integer getAuthorId() {
		return authorId;
	}


	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

}
