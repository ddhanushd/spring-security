package com.investor.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investor.model.Investors;
import com.investor.repository.InvestorRepository;

@Service
@Transactional
public class InvestorServiceImpl implements InvestorService {

	@Autowired
	InvestorRepository investorRepo;

	@Override
	public void addInvestor(Investors investor) {
		investorRepo.save(investor);

	}

	@Override
	public List<Investors> getallInvestors() {
		List<Investors> investor=investorRepo.findAll();
		return investor;
	}

//	@Override
//	public Investor findInvestorById(int id) {
//		Investor investor=investorRepo.findById(id).get();
//		return investor;
//	}
	@Override
	public Optional<Investors> findInvestorById(int id) {
		return investorRepo.findById(id);
	}

	@Override
	public void deleteInvestor(int id) {
		investorRepo.deleteById(id);

	}

	@Override
	public void updateInvestor(int id, Investors investor) {
		Investors investor1=investorRepo.findById(id).get();
		investor1.setInvestorName(investor.getInvestorName());
		investor1.setUsername(investor.getUsername());
		investor1.setPassword(investor.getPassword());
		investor1.setInvestorPhoneno(investor.getInvestorPhoneno());
		investor1.setInvestorEmail(investor.getInvestorEmail());
		investor1.setInvestorAddress(investor.getInvestorAddress());
		investorRepo.save(investor1);
	}

	@Override
	public Investors updateInvestorName(int id, Investors investor) {
		Investors investors=investorRepo.findById(id).get();
		investors.setInvestorName(investor.getInvestorName());
		return investorRepo.save(investors);
	}

	@Override
	public Investors updateInvestorDetails(int id, Investors investor) {
		Investors investor1=investorRepo.findById(id).get();
		investor1.setInvestorName(investor.getInvestorName());
		investor1.setUsername(investor.getUsername());
		investor1.setPassword(investor.getPassword());
		investor1.setInvestorPhoneno(investor.getInvestorPhoneno());
		investor1.setInvestorEmail(investor.getInvestorEmail());
		investor1.setInvestorAddress(investor.getInvestorAddress());
		return investorRepo.save(investor1);
	}

}
