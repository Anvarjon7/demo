package com.example.demo.repository;

import com.example.demo.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Set;

public interface FriendRepository extends JpaRepository<Friend,Long> {

    @Query("SELECT f FROM Friend f WHERE f.birthday = CURRENT_DATE ORDER BY f.lastName ASC")
    Set<Friend> findByBirthday();

    Set<Friend> findByFirstNameAndLastName(String firstName, String lastName);
}
