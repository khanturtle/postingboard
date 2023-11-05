package com.sparta.postingboard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.postingboard.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private String date;

    @JsonIgnore
    private String password;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.password = post.getPassword();
        this.contents = post.getContents();
        this.date = post.getDate();
        this.title = post.getTitle();
    }
}