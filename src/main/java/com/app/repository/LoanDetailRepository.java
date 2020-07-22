package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.LoanDetail;

@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetail, Integer> {

	List<LoanDetail> findByUserId(Integer userId);

}
