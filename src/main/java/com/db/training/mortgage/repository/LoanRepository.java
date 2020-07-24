package com.db.training.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.training.mortgage.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

	@Query(value="select * from loan l where l.loan_amount <= :propertyCost",nativeQuery=true)
	List<Loan> getAllLoanAmountBasedOnPropertyCost(@Param("propertyCost") double propertyCost);

	@Query(value="select * from loan l where l.loanemi <= :baseAmount",nativeQuery=true)
	List<Loan> getAllLoanAmountBasedOnBaseAmount(@Param("baseAmount") double baseAmount);
	
//	@Query(value="select * from employee u where u.user_name=:userName and u.password=:password", nativeQuery=true)
//	public Employee getEmployeeByNativeSql(@Param("userName") String userName, @Param("password") String password);

	
}
