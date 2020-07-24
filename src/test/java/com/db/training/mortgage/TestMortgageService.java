package com.db.training.mortgage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.db.training.mortgage.dto.UserRequestDto;
import com.db.training.mortgage.entity.Loan;
import com.db.training.mortgage.entity.Property;
import com.db.training.mortgage.entity.User;
import com.db.training.mortgage.repository.LoanDetailRepository;
import com.db.training.mortgage.repository.LoanRepository;
import com.db.training.mortgage.repository.PropertyRepository;
import com.db.training.mortgage.repository.PropertyValueRepository;
import com.db.training.mortgage.repository.UserRepository;
import com.db.training.mortgage.service.MortgageService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TestMortgageService {
	@InjectMocks
	MortgageService mortgageService;
	
	@Mock
	UserRepository userRepository;
	@Mock
	PropertyRepository propertyRepository;
	@Mock
	PropertyValueRepository propertyValueRepository;
	@Mock
	LoanRepository loanRepository;
	@Mock
	LoanDetailRepository loanDetailRepository;
	
	@Test
	public void testApplyMortgagesForValidInputs() {
		
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setDob(null);
		userRequestDto.setEmail("");
		userRequestDto.setGender("");
		userRequestDto.setName("");
		userRequestDto.setSalary(30000);
		userRequestDto.setSecondIncome(10000);
		userRequestDto.setOtherIncome(10000);
		
		User user = new User();
		Property property = new Property();
		BeanUtils.copyProperties(userRequestDto, user);
		
		property.setUserId(user.getUserId());
		BeanUtils.copyProperties(userRequestDto, property);
		
		List<Loan> list = new ArrayList<>();
		
		Mockito.when(userRepository.save(user)).thenReturn((User) (list));
		//Mockito.when(userRepository.save((property)).thenReturn((Property) (list));
		List<Loan> result = mortgageService.applyMortgages(userRequestDto);
		Assert.assertEquals(list, result);
	}
	
}
