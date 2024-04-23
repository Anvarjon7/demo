package com.example.demo.service;

import com.example.demo.dto.FriendRequestDto;
import com.example.demo.dto.FriendResponseDto;

import java.time.LocalDate;
import java.util.Set;

public interface FriendService {
    Set<FriendResponseDto> findAllFriends();
    FriendResponseDto findFriendById(Long id);
    FriendResponseDto createFriend(FriendRequestDto friendRequestDto);
    FriendResponseDto findFriendByBirthday(LocalDate birthday);
    Set<FriendResponseDto> findFriendsByFullName(String firstName, String lastName);
    Set<FriendResponseDto> findFriendsByBirthdayToday();
    void deleteFriendById(Long id);
}
