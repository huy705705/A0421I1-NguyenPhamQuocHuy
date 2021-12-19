package com.example.baitap1.controller;

import com.example.baitap1.model.Blog;
import com.example.baitap1.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String displayAllBlog(Model model, @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("blogs", blogService.findPageableALl(pageable));
        return "list";
    }

    @GetMapping("/create")
    public String displayCreateBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute(name = "blog") Blog blog) {
        blog.setId(Long.valueOf(blogService.findAll().size()) + 1);
        blogService.saveBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editBlogForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateBlog(Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String deleteBlogForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "delete";
    }

    @PostMapping("/remove")
    public String removeBlog(Blog blog){
        blogService.deleteBlog(blog);
        return "redirect:/";
    }
}
