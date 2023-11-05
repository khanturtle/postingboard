package com.sparta.postingboard.controller;

import com.sparta.postingboard.dto.PostRequestDto;
import com.sparta.postingboard.dto.PostResponseDto;
import com.sparta.postingboard.entity.Post;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class PostController {
    private final Map<Long, Post> postList = new HashMap<>();

    //게시물 작성하기
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);

        Long maxId = postList.size() > 0 ? Collections.max(postList.keySet()) + 1 : 1;
        post.setId(maxId);
        //DB 저장
        postList.put(post.getId(), post);
        //Entity -> ResponseDto
        PostResponseDto postResponseDto = new PostResponseDto(post);

        return postResponseDto;

    }
    //조회하기
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts(){
        List<PostResponseDto> responseList = postList.values().stream()
                .map(PostResponseDto::new).toList();

        return responseList;
    }
}
