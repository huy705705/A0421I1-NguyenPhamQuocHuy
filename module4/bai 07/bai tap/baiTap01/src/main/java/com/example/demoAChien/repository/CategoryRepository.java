package com.example.demoAChien.repository;

import com.example.demoAChien.model.Blog;
import com.example.demoAChien.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
