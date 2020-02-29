package com.so_mini.repository;

import com.so_mini.domain.Board;
import com.so_mini.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
