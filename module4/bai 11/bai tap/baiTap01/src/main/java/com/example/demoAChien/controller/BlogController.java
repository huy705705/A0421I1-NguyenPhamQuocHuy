package com.example.demoAChien.controller;

import com.example.demoAChien.model.Blog;
import com.example.demoAChien.model.Category;
import com.example.demoAChien.repository.CategoryRepository;
import com.example.demoAChien.service.BlogService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute("listCategory")
    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }

    @GetMapping("")
    public String displayAllBlog(Model model, Optional<String> key_search, Optional<Long> cateId,
                                 @PageableDefault(size = 2) Pageable pageable) {
        if (!key_search.isPresent()) {
            if (cateId.isPresent()) {
                model.addAttribute("cateId", cateId.get());
                model.addAttribute("blogs", blogService.findAllBlogByCategory(pageable, cateId.get()));
            } else {
                model.addAttribute("blogs", blogService.findAll(pageable));

            }
        } else {
            model.addAttribute("blogs", blogService.findAllBlogByAuthor(pageable, key_search.get()));

        }
        return "list";
    }

    @GetMapping("/create")
    public String displayCreateBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String displayCreateBlogForm(@ModelAttribute(name = "blog") Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String displayEditBlogForm(@PathVariable long id,Model model) {
        model.addAttribute("blog",blogService.findBlogById(id));
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
