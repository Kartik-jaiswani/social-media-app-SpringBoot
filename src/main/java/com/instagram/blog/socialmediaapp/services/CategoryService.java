package com.instagram.blog.socialmediaapp.services;

import com.instagram.blog.socialmediaapp.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create
    CategoryDto createCategory(CategoryDto categoryDto);
    //update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
    //delete
    void deleteCategory(Integer categoryId);
    //get
    CategoryDto getCategory(Integer categoryId);
    //get all
    List<CategoryDto> getAllCategories();
}
