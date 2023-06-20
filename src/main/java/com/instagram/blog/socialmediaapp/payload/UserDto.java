package com.instagram.blog.socialmediaapp.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 4,message = "Minimum chars in your name should be greater then 4")
    private String name;

    @Email(message = "Email address is not valid")
    private String email;

    @NotEmpty
    @Size(min = 3,max = 10,message = "password must be min of 3 chars and max of 10 chars")
//    @Pattern(regexp = "")
    private String password;

    @NotEmpty
    private String about;
}
