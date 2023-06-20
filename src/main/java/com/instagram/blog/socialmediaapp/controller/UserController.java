package com.instagram.blog.socialmediaapp.controller;

import com.instagram.blog.socialmediaapp.entities.User;
import com.instagram.blog.socialmediaapp.payload.ApiResponse;
import com.instagram.blog.socialmediaapp.payload.UserDto;
import com.instagram.blog.socialmediaapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST = create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //PUT = update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
        UserDto updateUserDto = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updateUserDto);
    }

    //    //DELETE = delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable() Integer userId){
        this.userService.deleteUser(userId);
//        return new ResponseEntity<>(Map.of("message","User deleted Successfully"),HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);

    }
    //    //GET = get user

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos = this.userService.getALLUsers();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable() Integer userId){
        UserDto userDto = this.userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }
}
