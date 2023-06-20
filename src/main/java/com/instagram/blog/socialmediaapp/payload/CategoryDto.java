package com.instagram.blog.socialmediaapp.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;

    @NotBlank
    @Size(min = 4)
    private String categoryTitle;

    @NotBlank
    @Size(min = 10)
    private String categoryDescription;
}
