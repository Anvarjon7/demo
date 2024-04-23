package com.example.demo.service.impl;

import com.example.demo.dto.FriendRequestDto;
import com.example.demo.dto.FriendResponseDto;
import com.example.demo.mapper.FriendMapper;
import com.example.demo.repository.FriendRepository;
import com.example.demo.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Slf4j
@Service
public class FriendsServiceImpl implements FriendService {

    private final FriendRepository friendRepository;
    private final FriendMapper friendMapper;

    @Autowired
    public FriendsServiceImpl(FriendRepository friendRepository, FriendMapper friendMapper) {
        this.friendRepository = friendRepository;
        this.friendMapper = friendMapper;
    }

    @Override
    public Set<FriendResponseDto> findAllFriends() {
        return friendMapper.toFriendResponseDtoSet(new HashSet<>(friendRepository.findAll()));
    }

    @Override
    public FriendResponseDto findFriendById(Long id) {
        return friendMapper.toFriendResponseDto(friendRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public FriendResponseDto createFriend(FriendRequestDto friendRequestDto) {
        return friendMapper.toFriendResponseDto(friendRepository.save(friendMapper.toFriend(friendRequestDto)));
    }

    @Override
    public FriendResponseDto findFriendByBirthday(LocalDate birthday) {
        return null;
    }

    @Override
    public Set<FriendResponseDto> findFriendsByFullName(String firstName, String lastName) {
        return friendMapper.toFriendResponseDtoSet(friendRepository.findByFirstNameAndLastName(lastName, firstName));
    }

    @Override
    public Set<FriendResponseDto> findFriendsByBirthdayToday() {
        return friendMapper.toFriendResponseDtoSet(friendRepository.findByBirthday());
    }

    @Override
    public void deleteFriendById(Long id) {
        friendRepository.deleteById(id);
    }
}
