package com.valiit.pvback.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("""
            select u from User u
            where upper(u.email) = upper(:email) and u.password = :password and upper(u.status) = upper(:status)""")
    User findUserById(@Param("email") String email, @Param("password") Integer password, @Param("status") String status);
}