package com.laotrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.laotrinhjavaweb.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	// Truy vấn user có username = username
	 @Query("SELECT u FROM User u WHERE u.username = :username")
	 User findByUsername(String username);
}
