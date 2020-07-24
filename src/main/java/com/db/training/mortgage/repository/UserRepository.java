package com.db.training.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.training.mortgage.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {

}
