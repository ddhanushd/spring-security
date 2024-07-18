package com.investor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.investor.exception.InvestorNotFoundException;
import com.investor.model.Investors;
import com.investor.repository.InvestorRepository;
import com.investor.service.InvestorService;


@RestController
@RequestMapping(value="/v1")
public class InvestorController {

	@Autowired
	InvestorService investorservice;

	@Autowired
	InvestorRepository investoryRepo;

	@GetMapping("/loadinvestors")
	public String loadInvestors() {
		return "Investor Details!";
	}
	
	/*
	 * @GetMapping("/login") public String login() { return "login"; // returns
	 * index.html from src/main/resources/templates }
	 */

	@PostMapping("/addinvestor")
	public void addInvestors(@RequestBody Investors investor) {
		investorservice.addInvestor(investor);
	}

	@GetMapping("/loadallinvestors")
	public List<Investors> getAllInvestors(){
		List<Investors>investor= investorservice.getallInvestors();
		return investor;
	}

//	@GetMapping("/investor/{id}")
//		public Investor getInvestorById(@PathVariable int id) {
//			Investor investor=investorservice.findInvestorById(id);
//			return investor;
//	}
	@GetMapping("/investor/{id}")
	public ResponseEntity<Investors> getInvestorById(@PathVariable int id){
		Optional<Investors> investor=investorservice.findInvestorById(id);
		if(investor.isPresent()) {
			return ResponseEntity.ok(investor.get());
		}
		throw new InvestorNotFoundException("Investor Not Found");
	}

//	@GetMapping("/investors/{name}")
//	public Investor getInvestorByName(@PathVariable String name) {
//		Investor investor=investoryRepo.findByinvestorName(name);
//		return investor;
//	}
	@GetMapping("/investors/{name}")
	public ResponseEntity<Investors> getInvestorByname(@PathVariable String name){
		Optional<Investors> investor=investoryRepo.findByinvestorName(name);
		if(investor.isPresent()) {
			return ResponseEntity.ok(investor.get());
		}
		throw new InvestorNotFoundException("Investor Not Found");

	}
	@DeleteMapping("/delete/{id}")
	public void deleteInvestors(@PathVariable int id) {
		if(investoryRepo.existsById(id)) {
			investorservice.deleteInvestor(id);
		}else {
			throw new InvestorNotFoundException("Investor Not Found");
		}
	}

//	@PutMapping("update/{id}")
//		public Investor updateInvestor(@RequestBody Investor investor, @PathVariable int id) {
//			investorservice.updateInvestor(id, investor);
//			return investor;
//	}
//	@PutMapping("update/{id}")
//	public ResponseEntity<Investors> updateInvestor(@RequestBody Investors investor, @PathVariable int id){
//		Optional<Investors> investor1=investoryRepo.findById(id);
//		if(investor1.isPresent()) {
//			investorservice.updateInvestor(id, investor);
//			return ResponseEntity.ok(investor1.get());
//		}
//		throw new InvestorNotFoundException("Investor Not Found");
//	}
	
	 @PutMapping("/update/{id}")
	    public ResponseEntity<Investors> updateInvestor(@RequestBody Investors investor, @PathVariable int id) {
	        try {
	            investorservice.updateInvestor(id, investor);
	            return ResponseEntity.ok(investor);
	        } catch (InvestorNotFoundException e) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
	        } catch (Exception e) {
	            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
	        }
	    }
	@PatchMapping("/updateName/{id}")
	public Investors updateInvestorName(@PathVariable int id, @RequestBody Investors investor) {
		if(investoryRepo.existsById(id)) {
			return investorservice.updateInvestorName(id, investor);
		}else {
			throw new InvestorNotFoundException("Investor Not Found");
		}
	}

	@PatchMapping("update/anydetails/{id}")
	public ResponseEntity<Investors> updateInvestorDetails(@RequestBody Investors investor, @PathVariable int id){
		Optional<Investors> investor1=investoryRepo.findById(id);
		if(investor1.isPresent()) {
			investorservice.updateInvestor(id, investor);
			return ResponseEntity.ok(investor1.get());
		}
		throw new InvestorNotFoundException("Investor Not Found");
	}

}




