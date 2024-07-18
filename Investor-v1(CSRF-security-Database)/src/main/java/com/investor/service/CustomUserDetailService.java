package com.investor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.investor.exception.InvestorNotFoundException;
import com.investor.model.CustomUserDetail;
import com.investor.model.Investors;
import com.investor.repository.InvestorRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private InvestorRepository investorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Investors investors=this.investorRepository.findByusername(username);
		if(investors==null) {
			throw new InvestorNotFoundException("No User");
		}
		return new CustomUserDetail(investors);
	}
 
}
