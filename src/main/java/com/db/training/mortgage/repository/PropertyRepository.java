package com.db.training.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.training.mortgage.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>{

}
