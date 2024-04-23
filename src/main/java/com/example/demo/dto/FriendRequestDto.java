package com.example.demo.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;

public record FriendRequestDto(
        @NotBlank @Size(min = 1) String firstName,
        @NotBlank @Size(min = 1) String lastName,
        @Past @NotNull @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy") LocalDate birthday,
        @NotBlank @Email String email
) {
}
