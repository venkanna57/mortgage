package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.PropertyValue;

@Repository
public interface PropertyValueRepository extends JpaRepository<PropertyValue, Integer> {

	PropertyValue findByPincode(String propertyPicode);

}
