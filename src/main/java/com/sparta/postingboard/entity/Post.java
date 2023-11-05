package com.sparta.postingboard.entity;

import com.sparta.postingboard.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String username;
    private String password;
    private String contents;
    private String date;

    public Post(PostRequestDto requestDto) {
        this.username=requestDto.getUsername();
        this.contents=requestDto.getContents();
        this.date=requestDto.getDate();
        this.title=requestDto.getTitle();
    }
}