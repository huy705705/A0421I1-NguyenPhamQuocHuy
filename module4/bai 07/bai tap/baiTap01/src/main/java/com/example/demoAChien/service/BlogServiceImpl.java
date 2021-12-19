package com.example.demoAChien.service;

import com.example.demoAChien.model.Blog;
import com.example.demoAChien.repository.BlogRepository;
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
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllBlogByAuthor(Pageable pageable, String author) {
        return blogRepository.findAllByAuthorContaining(pageable,author);
    }

    @Override
    public Page<Blog> findAllBlogByCategory(Pageable pageable, long id) {
        return blogRepository.findAllByCategoryId(pageable,id);
    }

    @Override
    public List<Blog> findById() {
        return null;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog findBlogById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBlog(Blog blog) {
        blogRepository.delete(blog);
    }

}
