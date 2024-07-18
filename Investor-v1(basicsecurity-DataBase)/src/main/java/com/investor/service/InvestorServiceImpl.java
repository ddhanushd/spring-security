package com.investor.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.investor.exception.InvestorNotFoundException;
import com.investor.model.Investors;
import com.investor.repository.InvestorRepository;

@Service
@Transactional
public class InvestorServiceImpl implements InvestorService {

	@Autowired
	InvestorRepository investorRepo;

	@Autowired
	PasswordEncoder passwordEncoder;
	//
	//	@Override
	//	public void addInvestor(Investors investor) {
	//		investorRepo.save(investor);
	//
	//	}

	@Override
	public void addInvestor(Investors investor) {
		// Hash the password before saving
		String hashedPassword=passwordEncoder.encode(investor.getPassword());
		investor.setPassword(hashedPassword);
		investorRepo.save(investor);// Set the hashed password
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

	//	@Override
	//	public void updateInvestor(int id, Investors investor) {
	//		Investors investor1=investorRepo.findById(id).get();
	//		investor1.setInvestorName(investor.getInvestorName());
	//		investor1.setUsername(investor.getUsername());
	//		investor1.setPassword(investor.getPassword());
	//		investor1.setInvestorPhoneno(investor.getInvestorPhoneno());
	//		investor1.setInvestorEmail(investor.getInvestorEmail());
	//		investor1.setInvestorAddress(investor.getInvestorAddress());
	//		investorRepo.save(investor1);
	//	}

	@Override
	public void updateInvestor(int id, Investors investor) {
		Optional<Investors> existingInvestor = investorRepo.findById(id);
		if (existingInvestor.isPresent()) {
			Investors updatedInvestor = existingInvestor.get();
			updatedInvestor.setInvestorName(investor.getInvestorName());
			updatedInvestor.setUsername(investor.getUsername());

			// Hash the new password before updating (if password changed)
			if (!investor.getPassword().equals(updatedInvestor.getPassword())) {
				String hashedPassword = passwordEncoder.encode(investor.getPassword());
				updatedInvestor.setPassword(hashedPassword);
			}

			updatedInvestor.setInvestorPhoneno(investor.getInvestorPhoneno());
			updatedInvestor.setInvestorEmail(investor.getInvestorEmail());
			updatedInvestor.setInvestorAddress(investor.getInvestorAddress());

			// Save the updated investor
			investorRepo.save(updatedInvestor);
		} else {
			throw new InvestorNotFoundException("Investor not found with id: " + id);
		}
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
