package com.tidz.registrationTuto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidz.registrationTuto.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
