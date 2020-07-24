package com.db.training.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.training.mortgage.entity.PropertyValue;

@Repository
public interface PropertyValueRepository extends JpaRepository<PropertyValue, Integer>{
	PropertyValue findByPincode(String propertyPicode);
}
