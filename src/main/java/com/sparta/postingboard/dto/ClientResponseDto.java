package com.sparta.postingboard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.postingboard.entity.Client;
import lombok.Getter;

@Getter
public class ClientResponseDto {
    private String username;
    @JsonIgnore
    private String password;

    public ClientResponseDto(Client client) {
        this.username=client.getUsername();
        this.password=client.getPassword();
    }
}
