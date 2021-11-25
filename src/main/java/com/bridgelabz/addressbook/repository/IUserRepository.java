package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {}
