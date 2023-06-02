package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>  {
	
	public List<User> findByName(String name);
	
	@Query(value = "select * from user where name = ?", nativeQuery = true)
	public User getUser(String name);

}
