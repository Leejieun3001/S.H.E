package com.so_mini.repository;

import com.so_mini.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Integer> {
    boolean existsByNickname(String nickname);

    Account findByNickname(String nickname);
}
