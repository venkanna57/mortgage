package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PropertyValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer propertyValueId;
	
	private String pincode;
	
	private double squareFeetValue;

	public Integer getPropertyValueId() {
		return propertyValueId;
	}

	public void setPropertyValueId(Integer propertyValueId) {
		this.propertyValueId = propertyValueId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public double getSquareFeetValue() {
		return squareFeetValue;
	}

	public void setSquareFeetValue(double squareFeetValue) {
		this.squareFeetValue = squareFeetValue;
	}
	
	


}
