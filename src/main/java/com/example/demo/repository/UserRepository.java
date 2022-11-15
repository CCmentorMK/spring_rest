package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    // gdy będziemy zmieniać hasła wszystkim istniejącym użytkownikom
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = : encodedPassword")
    void encodePasswordForAllUsers(@Param("encodedPassword") String encodedPassword);

}
