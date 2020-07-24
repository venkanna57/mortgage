package com.db.training.mortgage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loan{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer loanId;
	 
	 private Double loanAmount;
	 private Double interestRate;

	 private Integer tenurePeriod;
	 private Double loanEMI;
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public Integer getTenurePeriod() {
		return tenurePeriod;
	}
	public void setTenurePeriod(Integer tenurePeriod) {
		this.tenurePeriod = tenurePeriod;
	}
	public Double getLoanEMI() {
		return loanEMI;
	}
	public void setLoanEMI(Double loanEMI) {
		this.loanEMI = loanEMI;
	}

	

	
}
