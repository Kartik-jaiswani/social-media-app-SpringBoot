package com.instagram.blog.socialmediaapp.repositories;

import com.instagram.blog.socialmediaapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
