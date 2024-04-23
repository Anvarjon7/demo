package com.example.demo.controller;

import com.example.demo.dto.FriendRequestDto;
import com.example.demo.dto.FriendResponseDto;
import com.example.demo.service.FriendService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@Validated
@RestController
@RequestMapping("api/friends")
public class FriendsController {

    private final FriendService friendService;

    @Autowired
    public FriendsController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping
    public Set<FriendResponseDto> getAllFriends() {
        return friendService.findAllFriends();
    }

    @PostMapping("/create")
    public FriendResponseDto createFriend(@Valid @RequestBody FriendRequestDto friendRequestDto) {
        return friendService.createFriend(friendRequestDto);
    }

    @GetMapping("/{id}")
    public FriendResponseDto findFriendById(@PathVariable Long id) {
        return friendService.findFriendById(id);
    }

    @GetMapping("/date")
    public FriendResponseDto findByBirthday(@NotNull @RequestParam LocalDate birthDate) {
        return friendService.findFriendByBirthday(birthDate);
    }

    @GetMapping("name")
    public Set<FriendResponseDto> findFriendsByBirthday(@NotNull @RequestParam String firstName,
                                                        @NotNull @RequestParam String lastName) {
        return friendService.findFriendsByFullName(firstName, lastName);
    }

    @GetMapping("hasBirthday")
    Set<FriendResponseDto> findFriendsByBirthdayToday() {
        return friendService.findFriendsByBirthdayToday();
    }

    @DeleteMapping("/{id}")
    public void deleteFriendById(@Positive @NotNull @PathVariable Long id) {
        friendService.deleteFriendById(id);
    }

}
