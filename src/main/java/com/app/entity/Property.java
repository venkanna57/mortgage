package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer propertyId;
	
	private String propertyName;
	
	private String propertyType;
	
	private String propertyAddress;
	
	private double propertyArea;
	
	private String propertyPincode;
	
	private Integer userId;

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public double getPropertyArea() {
		return propertyArea;
	}

	public void setPropertyArea(double propertyArea) {
		this.propertyArea = propertyArea;
	}

	public String getPropertyPincode() {
		return propertyPincode;
	}

	public void setPropertyPincode(String propertyPincode) {
		this.propertyPincode = propertyPincode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	


}
