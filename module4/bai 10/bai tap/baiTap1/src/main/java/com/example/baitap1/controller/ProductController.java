package com.example.baitap1.controller;

import com.example.baitap1.model.Cart;
import com.example.baitap1.model.Product;
import com.example.baitap1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/product")
@SessionAttributes("carts")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("carts")
    public HashMap<Long, Cart> cartHashMap() {
        return new HashMap<>();
    }

    @GetMapping("/list")
    public String showList(Model model, HttpSession session) {
        System.out.println(session.getAttribute("carts"));
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/create-product")
    public String showFormCreate(@ModelAttribute("carts") HashMap<Long, Cart> hashMap, Model model) {
        System.out.println(hashMap.keySet());
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create-product")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("messsage", "New product created successfully");
        return "redirect:/product/list";
    }

    @GetMapping("/view-product/{id}")
    public String viewProduct(@PathVariable Long id, Model model, @ModelAttribute("carts") HashMap<Long, Cart> cartHashMap) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/delete-product/{id}")
    public String showDeleteProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }

    @PostMapping("/delete-product/{id}")
    public String deleteProduct(@ModelAttribute Product product, @PathVariable Long id) {
        productService.remove(id);
        return "redirect:/product/list";
    }
}
