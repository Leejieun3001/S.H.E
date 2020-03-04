package com.she.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.she.domain.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
	
}
