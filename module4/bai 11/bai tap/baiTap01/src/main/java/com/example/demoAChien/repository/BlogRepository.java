package com.example.demoAChien.repository;

import com.example.demoAChien.model.Blog;
import com.example.demoAChien.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAllByAuthorContaining(Pageable pageable,String author);

    @Query(value = "select * from blog join category where blog.category_id=category.id and category_id = :id",
            nativeQuery = true)
    Page<Blog> findAllByCategoryId(Pageable pageable,@Param("id") long id);


    @Query(value = "select * from blog join category where blog.category_id=category.id and category_id = :id",
            nativeQuery = true)
    List<Blog> findAllByCategoryIdWithList(@Param("id") long id);
}
