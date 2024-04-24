package com.valiit.pvback.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where upper(u.email) = upper(:email) and u.password = :password and upper(u.status) = upper(:status)")
    Optional<User> findUserBy(@Param("email") String email, @Param("password") String password, @Param("status") String status);

    @Query("select u from User u where u.status = :status and (upper(u.email) like upper(concat('%', :userInput, '%')) or upper(u.name) like upper(concat('%', :userInput, '%')))")
    List<User> findUsersByContains(String status, String userInput);

}