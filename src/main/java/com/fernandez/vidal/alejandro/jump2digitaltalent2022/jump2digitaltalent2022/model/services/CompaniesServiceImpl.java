package com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.domain.Companies;
import com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.repository.CompaniesRepository;

@Service
public class CompaniesServiceImpl implements CompaniesService {

	@Autowired
	CompaniesRepository companiesRepository;

	@Override
	public List<Companies> getCompaniesBySize() {

		List<Companies> companiesBySize = companiesRepository.findAll();
		Collections.sort(companiesBySize, new Comparator<Companies>() {

			@Override
			public int compare(Companies o1, Companies o2) {
				int resultado;
				
					if (o1.getSize().indexOf("-") > o2.getSize().indexOf("-")) {
						resultado = 1;
					} else if (o1.getSize().indexOf("-") < o2.getSize().indexOf("-")) {
						resultado = -1;
					} else if (o1.getSize().charAt(0) > o2.getSize().charAt(0)) {
						resultado = 1;
					} else if (o1.getSize().charAt(0) < o2.getSize().charAt(0)) {
						resultado = -1;
					} else {
						resultado = 0;
					}
					
				return resultado;
				}
			});

		return companiesBySize;
	}

	@Override
	public List<Companies> getCompaniesByFounded() {
		List<Companies> companiesByFounded = companiesRepository.findAll();
		companiesByFounded.sort(Comparator.comparing(Companies::getFounded));
		return companiesByFounded;
	}

	@Override
	public String getSomeInformationAboutCompanies() {

		List<Companies> companiesSomeInfo = companiesRepository.findAll();

		TreeMap<String, Integer> industry = obtenerCantidadByIndustry(companiesSomeInfo);
		HashMap<String, Integer> size = obtenerCantidadBySize(companiesSomeInfo);
		TreeMap<Integer, Integer> founded = obtenerCantidadByFounded(companiesSomeInfo);

		return "Número de empresas por industria : " + industry + "\n Número de empresas por tamañao : " + size
				+ "\n Número de empresas por año de creación : " + founded;

	}

	public TreeMap<String, Integer> obtenerCantidadByIndustry(List<Companies> companiesSomeInfo) {

		List<String> listadoIndustry = List.of("accounting", "airlines/aviation", "animation", "apparel & fashion",
				"architecture & planning", "arts and crafts", "automotive", "aviation & aerospace", "banking",
				"biotechnology", "building materials", "business supplies and equipment", "chemicals",
				"civic & social organization", "civil engineering", "commercial real estate",
				"computer & network security", "computer games", "computer hardware", "computer software",
				"construction", "consumer electronics", "consumer goods", "consumer services", "cosmetics", "design",
				"e-learning", "education management", "electrical/electronic manufacturing", "entertainment",
				"environmental services", "events services", "facilities services", "farming", "financial services",
				"fine art", "food & beverages", "food production", "furniture", "government administration",
				"government relations", "health, wellness and fitness", "higher education", "hospital & health care",
				"hospitality", "human resources", "import and export", "individual & family services",
				"industrial automation", "information services", "information technology and services", "insurance",
				"international affairs", "international trade and development", "internet", "investment banking",
				"investment management", "judiciary", "law enforcement", "law practice", "legal services",
				"leisure, travel & tourism", "logistics and supply chain", "luxury goods & jewelry", "machinery",
				"management consulting", "maritime", "market research", "marketing and advertising",
				"mechanical or industrial engineering", "media production", "medical devices", "medical practice",
				"mining & metals", "motion pictures and film", "music", "nanotechnology", "newspapers",
				"non-profit organization management", "oil & energy", "online media", "outsourcing/offshoring",
				"packaging and containers", "paper & forest products", "performing arts", "pharmaceuticals",
				"philanthropy", "photography", "printing", "professional training & coaching",
				"public relations and communications", "publishing", "real estate",
				"recreational facilities and services", "religious institutions", "renewables & environment",
				"research", "restaurants", "retail", "security and investigations", "sporting goods", "sports",
				"staffing and recruiting", "telecommunications", "textiles", "tobacco", "translation and localization",
				"transportation/trucking/railroad", "veterinary", "warehousing", "wholesale", "wine and spirits",
				"wireless", "writing and editing");
		TreeMap<String, Integer> listadoResultado = new TreeMap<String, Integer>();
		int contadores[] = new int[115];

		int contadorNull = 0;

		for (int i = 0; i < companiesSomeInfo.size(); i++) {
			boolean condicion = false;
			Companies companie = companiesSomeInfo.get(i);

			if (companie.getIndustry() == null) {
				contadorNull++;
			} else {
				int j = 0;
				while (j <= listadoIndustry.size() && condicion == false) {
					String industryBuscar = companie.getIndustry();
					if (industryBuscar.equalsIgnoreCase(listadoIndustry.get(j))) {
						condicion = true;
						int resultado = contadores[j] + 1;
						contadores[j] = resultado;
					}
					j++;
				}

				for (int a = 0; a < listadoIndustry.size(); a++) {
					listadoResultado.put(listadoIndustry.get(a), contadores[a]);
				}
				listadoResultado.put("null", contadorNull);
			}
		}
		return listadoResultado;

	}

	public HashMap<String, Integer> obtenerCantidadBySize(List<Companies> companiesSomeInfo) {

		List<String> listadoSize = List.of("1-10", "10001+", "1001-5000", "11-50", "201-500", "5001-10000", "501-1000",
				"51-200");
		HashMap<String, Integer> listadoResultado = new HashMap<String, Integer>();
		int contadores[] = new int[8];

		for (int i = 0; i < companiesSomeInfo.size(); i++) {
			boolean condicion = false;
			Companies companie = companiesSomeInfo.get(i);

			int j = 0;
			while (j <= listadoSize.size() && condicion == false) {
				String sizeBuscar = companie.getSize();
				if (sizeBuscar.equalsIgnoreCase(listadoSize.get(j))) {
					condicion = true;
					int resultado = contadores[j] + 1;
					contadores[j] = resultado;
				}
				j++;
			}
			for (int a = 0; a < listadoSize.size(); a++) {
				listadoResultado.put(listadoSize.get(a), contadores[a]);
			}

		}
		return listadoResultado;

	}

	public TreeMap<Integer, Integer> obtenerCantidadByFounded(List<Companies> companiesSomeInfo) {

		List<Integer> listadoFounded = List.of(1792, 1887, 1903, 1911, 1918, 1921, 1923, 1925, 1926, 1934, 1935, 1937,
				1938, 1946, 1951, 1958, 1960, 1961, 1962, 1963, 1964, 1968, 1970, 1971, 1975, 1976, 1978, 1979, 1981,
				1982, 1983, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999,
				2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016,
				2017, 2018, 2019, 2020);
		TreeMap<Integer, Integer> listadoResultado = new TreeMap<>();
		int contadores[] = new int[68];

		int contadorNull = 0;

		for (int i = 0; i < companiesSomeInfo.size(); i++) {
			boolean condicion = false;
			Companies companie = companiesSomeInfo.get(i);

			if (companie.getFounded() == 0) {
				contadorNull++;
			} else {
				int j = 0;
				while (j <= listadoFounded.size() && condicion == false) {
					int industryBuscar = companie.getFounded();
					if (industryBuscar == listadoFounded.get(j)) {
						condicion = true;
						int resultado = contadores[j] + 1;
						contadores[j] = resultado;
					}
					j++;
				}

				for (int a = 0; a < listadoFounded.size(); a++) {
					listadoResultado.put(listadoFounded.get(a), contadores[a]);
				}
				listadoResultado.put(0, contadorNull);
			}
		}

		return listadoResultado;
	}
}