package com.example.demoAChien.service;

import com.example.demoAChien.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    public List<Blog> findAll();
    public Page<Blog> findAll(Pageable pageable);
    public Page<Blog> findAllBlogByAuthor(Pageable pageable,String author);
    public Page<Blog> findAllBlogByCategory(Pageable pageable,long id );
    public List<Blog> findById();
    public Blog saveBlog(Blog blog);
    public void deleteBlog(Blog blog);

    public Blog findBlogById(long id);
}
