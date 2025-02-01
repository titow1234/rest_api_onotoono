package com.one.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.onetoone.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
