package com.instagram.blog.socialmediaapp.services;

import com.instagram.blog.socialmediaapp.payload.UserDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getALLUsers();
    void deleteUser(Integer userId);
}
