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

        Long maxId = !postList.isEmpty() ? Collections.max(postList.keySet()) + 1 : 1;
        post.setId(maxId);
        //DB 저장
        postList.put(post.getId(), post);
        //Entity -> ResponseDto
        return new PostResponseDto(post);
    }

    //게시글 목록 조회하기
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return postList.values().stream()
                .map(PostResponseDto::new).toList();
    }

    //id로 게시글 조회
    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        if (postList.containsKey(id)) {
            return postList.get(id);
        } else {
            throw new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.");
        }
    }

    //게시글 수정
    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        //포스트 DB에 존재 하는지 확인
        if (postList.containsKey(id)) {
            Post post = postList.get(id);
            //게시글 수정 매서드
            if (post.getPassword().equals(requestDto.getPassword())) {
                post.update(requestDto);
                return post;
            } else
                throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        } else {
            throw new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.");
        }
    }

    //게시글 삭제
    @DeleteMapping("posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        if (postList.containsKey(id)) {
            Post post = postList.get(id);
            if (post.getPassword().equals(requestDto.getPassword())) {   //비밀번호 일치할 시
                postList.remove(id);
            } else throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
            return id;
        } else {
            throw new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.");
        }
    }
}
