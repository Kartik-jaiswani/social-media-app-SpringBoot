package com.instagram.blog.socialmediaapp.repositories;

import com.instagram.blog.socialmediaapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
