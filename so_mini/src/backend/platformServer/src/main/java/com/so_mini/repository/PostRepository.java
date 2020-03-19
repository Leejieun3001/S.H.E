package com.so_mini.repository;

import com.so_mini.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author :jeun
 * @Description : Post 리파지토리 인터페이스
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findById(int id);
}
