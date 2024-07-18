package com.investor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investor.model.Investors;


@Repository
public interface InvestorRepository extends JpaRepository<Investors, Integer> {
	Optional<Investors> findByinvestorName(String name);

	Investors findByusername(String username);

}
