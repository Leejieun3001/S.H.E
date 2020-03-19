package com.so_mini.repository;


import com.so_mini.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByNickname(String nickname);

	User findByNickname(String nickname);
}
