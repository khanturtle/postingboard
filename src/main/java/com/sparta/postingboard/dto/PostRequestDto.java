package com.sparta.postingboard.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private Long id;
    private String title;
    private String username;
    private String password;
    private String contents;
    private String date;
}