package com.sparta.postingboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.postingboard.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private String date;
    private boolean complete = false; //완료 여부
    //비밀번호 반환 하지 않게 처리
    @JsonIgnore
    private String password;

    public Post(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.date = requestDto.getDate();
        this.password = requestDto.getPassword();
    }

    public void update(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }
}