package com.example.restblog.data;

import com.example.restblog.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Long> {

    Category findCategoryByName(String category);

}
