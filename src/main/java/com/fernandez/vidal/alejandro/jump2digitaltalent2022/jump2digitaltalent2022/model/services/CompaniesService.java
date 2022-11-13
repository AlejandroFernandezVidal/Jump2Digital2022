package com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.services;

import com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.domain.Companies;

public interface CompaniesService {
	
	public Iterable<Companies> getCompaniesBySize();
	
	public Iterable<Companies> getCompaniesByFounded();
	
	public String getSomeInformationAboutCompanies();

}