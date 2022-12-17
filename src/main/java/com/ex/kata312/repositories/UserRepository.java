package com.ex.kata312.repositories;

import com.ex.kata312.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
