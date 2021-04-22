package com.epam.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.guest.entity.User;

public interface GuestRepository extends JpaRepository<User, Integer> {

}
