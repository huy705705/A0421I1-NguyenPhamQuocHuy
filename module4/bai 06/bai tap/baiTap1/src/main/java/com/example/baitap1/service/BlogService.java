package com.example.baitap1.service;

import com.example.baitap1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    public List<Blog> findAll();

    public Blog findBlogById(long id);

    public Page<Blog> findPageableALl(Pageable pageable);

    public Blog saveBlog(Blog blog);

    public void deleteBlog(Blog blog);

}
