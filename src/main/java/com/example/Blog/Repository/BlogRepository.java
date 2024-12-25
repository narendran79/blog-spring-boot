package com.example.Blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Blog.Model.Blog;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByTitle(String title);
	List<Blog> findByAuthorId(Integer authorId);
}

