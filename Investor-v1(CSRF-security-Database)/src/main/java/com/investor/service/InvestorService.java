package com.investor.service;

import java.util.List;
import java.util.Optional;

import com.investor.model.Investors;

public interface InvestorService {
	void addInvestor(Investors investor);
	List<Investors> getallInvestors();
	//Investor findInvestorById(int id);
	Optional<Investors> findInvestorById(int id);
	void deleteInvestor(int id);
	void updateInvestor(int id, Investors investor);
	Investors updateInvestorName(int id, Investors investor);
	Investors updateInvestorDetails(int id, Investors investor);

}
