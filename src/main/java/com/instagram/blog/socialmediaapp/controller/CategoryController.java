package com.instagram.blog.socialmediaapp.controller;

import com.instagram.blog.socialmediaapp.entities.Category;
import com.instagram.blog.socialmediaapp.payload.ApiResponse;
import com.instagram.blog.socialmediaapp.payload.CategoryDto;
import com.instagram.blog.socialmediaapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Post
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCatDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCatDto, HttpStatus.CREATED);
    }

    //Put
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("categoryId") Integer catID){
        CategoryDto updatedCatDto = this.categoryService.updateCategory(categoryDto,catID);
        return ResponseEntity.ok(updatedCatDto);
    }
    //Delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category removed Successfully",true),HttpStatus.OK);
    }
    //Get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
        CategoryDto categoryDto = this.categoryService.getCategory(categoryId);
        return ResponseEntity.ok(categoryDto);
    }
    //Get All
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categoryDtos = this.categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDtos);
    }
}
