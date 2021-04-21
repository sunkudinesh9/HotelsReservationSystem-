package com.epam.guestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.guestservice.entity.User;

public interface GuestServiceRepository extends JpaRepository<User, Integer> {

}
