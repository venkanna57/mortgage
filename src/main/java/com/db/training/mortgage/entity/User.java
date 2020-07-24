package com.db.training.mortgage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer userId;
	private String name;
	private Date dob;
	private String gender;
	private Integer phoneNumber;
	private String email;
	private String panNumber;
	private Double salary;
    private Double secondIncome;
    private Double otherIncome;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getSecondIncome() {
		return secondIncome;
	}
	public void setSecondIncome(Double secondIncome) {
		this.secondIncome = secondIncome;
	}
	public Double getOtherIncome() {
		return otherIncome;
	}
	public void setOtherIncome(Double otherIncome) {
		this.otherIncome = otherIncome;
	}
		
}
