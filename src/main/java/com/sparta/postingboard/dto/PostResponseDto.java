package com.sparta.postingboard.dto;

import com.sparta.postingboard.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String username;
    private String password;
    private String contents;
    private String date;

    public PostResponseDto(Post post) {
        this.id=post.getId();
        this.username=post.getUsername();
        this.contents=post.getContents();
        this.date=post.getDate();
        this.title=post.getTitle();
    }
}