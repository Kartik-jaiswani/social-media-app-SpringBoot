package com.instagram.blog.socialmediaapp.services.impl;

import com.instagram.blog.socialmediaapp.entities.User;
import com.instagram.blog.socialmediaapp.expections.*;
import com.instagram.blog.socialmediaapp.payload.UserDto;
import com.instagram.blog.socialmediaapp.repositories.UserRepo;
import com.instagram.blog.socialmediaapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow((() -> new ResourceNotFoundException("User","ID",userId)));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);

        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow((() -> new ResourceNotFoundException("User","ID",userId)));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getALLUsers() {
        List<User> users = this.userRepo.findAll();
//        List<UserDto> userDtos = new ArrayList<>();
//        for (User user: users) {
//            userDtos.add(this.userToDto(user));
//        }
// ----------- yh mera logic tha-----------------
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","ID",userId));

        this.userRepo.delete(user);
    }
    public User dtoToUser(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);

//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());

        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = modelMapper.map(user,UserDto.class);

//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());

        return userDto;
    }
}
