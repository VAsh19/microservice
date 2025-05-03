package com.microservice.authentication_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.authentication_service.entity.User;

public interface UserRepository extends JpaRepository<User , Integer> {

	Optional<User> findByUserName(String username);

}
