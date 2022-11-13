package com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.domain.Companies;
import com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.services.CompaniesServiceImpl;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

	@Autowired
	CompaniesServiceImpl companiesServiceImpl;

	@GetMapping("/getCompaniesBySize")
	public List<Companies> getCompaniesBySize() {
		List<Companies> listadoBySize = companiesServiceImpl.getCompaniesBySize();
		return listadoBySize;
	}

	@GetMapping("/getCompaniesByFounded")
	public List<Companies> getCompaniesByFounded() {
		List<Companies> listadoByFounded = companiesServiceImpl.getCompaniesByFounded();
		return listadoByFounded;

	}

	@GetMapping("/getSomeInformationAboutCompanies")
	public String getSomeInformationAboutCompanies() {
		String resultado = companiesServiceImpl.getSomeInformationAboutCompanies();
		return resultado;
	}
}