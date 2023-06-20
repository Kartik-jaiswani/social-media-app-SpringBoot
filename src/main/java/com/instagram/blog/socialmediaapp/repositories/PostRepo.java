package com.instagram.blog.socialmediaapp.repositories;

import com.instagram.blog.socialmediaapp.entities.Category;
import com.instagram.blog.socialmediaapp.entities.Post;
import com.instagram.blog.socialmediaapp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
//    Page<Post> findByUserPageable(User user, Pageable p);
    List<Post> findByCategory(Category category);

//    List<Post> findByTitleContaining(String keyword);

    @Query("select p from Post p where p.title like :key")
    List<Post> searchByTitle(@Param("key") String keyword);
}
