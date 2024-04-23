package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record FriendResponseDto(
        Long id,
        String firstname,
        String lastname,
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy") LocalDate birthday,
        String email
) {
}
