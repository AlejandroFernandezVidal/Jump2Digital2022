package com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.domain.Companies;

public interface CompaniesRepository extends MongoRepository<Companies, String> {
	

}
