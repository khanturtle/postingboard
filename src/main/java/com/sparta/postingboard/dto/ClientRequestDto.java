package com.sparta.postingboard.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ClientRequestDto {
    @NotNull
    @Size(min=4,max=10)
    @Pattern(regexp = "^[a-z0-9]*$")
    private String username;

    @NotNull
    @Size(min=8,max=15)
    @Pattern(regexp = "^a-zA-Z0-9*$")
    private String password;
}
