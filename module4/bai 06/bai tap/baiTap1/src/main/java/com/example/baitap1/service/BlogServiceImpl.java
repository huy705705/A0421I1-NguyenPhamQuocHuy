package com.example.baitap1.service;

import com.example.baitap1.model.Blog;
import com.example.baitap1.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findBlogById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findPageableALl(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {
         blogRepository.delete(blog);
    }
}
