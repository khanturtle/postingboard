package com.sparta.postingboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.postingboard.dto.ClientRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Client {
    private String username;
    @JsonIgnore
    private String password;

    public Client(ClientRequestDto requestDto) {
        this.username=requestDto.getUsername();
        this.password=requestDto.getPassword();
    }
}
