package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoanDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanDetailId;
	
	private Integer loanId;
	
	private Integer userId;

	public Integer getLoanDetailId() {
		return loanDetailId;
	}

	public void setLoanDetailId(Integer loanDetailId) {
		this.loanDetailId = loanDetailId;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
}
