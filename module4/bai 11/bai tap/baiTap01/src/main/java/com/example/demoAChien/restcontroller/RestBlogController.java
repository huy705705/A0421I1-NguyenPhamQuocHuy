package com.example.demoAChien.restcontroller;

import com.example.demoAChien.model.Blog;
import com.example.demoAChien.model.Category;
import com.example.demoAChien.repository.BlogRepository;
import com.example.demoAChien.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestBlogController {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/api/category/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @GetMapping("/api/blog/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @GetMapping("/api/blog/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Blog getAllBlog(@PathVariable(name = "id") Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @GetMapping("/api/blog/list/by/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> getAllBlogByCategory(@PathVariable(name = "id") Long id) {
        return  blogRepository.findAllByCategoryIdWithList(id);
    }
}
