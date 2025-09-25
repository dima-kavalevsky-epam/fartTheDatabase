package com.fartone.cardapp.repository;

// public class UserRepository {
// import com.fartone.usercardapp.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fartone.cardapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // Named Method
    Optional<User> findByEmail(String email);

    // JPQL Query
    @Query("SELECT u FROM User u WHERE u.birthDate > :date")
    List<User> findUsersBornAfter(@Param("date") LocalDate date);

    // Native SQL Query
    @Query(value = "SELECT * FROM users WHERE name = ?1", nativeQuery = true)
    List<User> findUsersByName(String name);
}