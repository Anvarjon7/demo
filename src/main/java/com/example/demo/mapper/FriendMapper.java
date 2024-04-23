package com.example.demo.mapper;

import com.example.demo.dto.FriendRequestDto;
import com.example.demo.dto.FriendResponseDto;
import com.example.demo.entity.Friend;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FriendMapper {
    public FriendResponseDto toFriendResponseDto(Friend friend) {
        return new FriendResponseDto(
                friend.getId(),
                friend.getFirstName(),
                friend.getLastName(),
                friend.getBirthday(),
                friend.getEmail()
        );
    }

    public Friend toFriend(FriendRequestDto friendResponseDto) {
        return new Friend(null,friendResponseDto.firstName(), friendResponseDto.lastName(), friendResponseDto.birthday(), friendResponseDto.email());

    }

    public Set<FriendResponseDto> toFriendResponseDtoSet(Set<Friend> friendSet) {
        return friendSet.stream().map(this::toFriendResponseDto).collect(Collectors.toSet());
    }
}
