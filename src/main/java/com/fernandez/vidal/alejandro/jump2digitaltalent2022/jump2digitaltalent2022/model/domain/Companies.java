package com.fernandez.vidal.alejandro.jump2digitaltalent2022.jump2digitaltalent2022.model.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Companies")
public class Companies {

	@Id
	private String id;

	private String website;

	private String name;

	private int founded;

	private String size;

	private String locality;

	private String region;

	private String country;

	private String industry;

	private String linkedin_url;

	public Companies() {

	}

	public Companies(String id, String website, String name, int founded, String size, String locality, String region,
			String country, String industry, String linkedin_url) {

		this.id = id;
		this.website = website;
		this.name = name;
		this.founded = founded;
		this.size = size;
		this.locality = locality;
		this.region = region;
		this.country = country;
		this.industry = industry;
		this.linkedin_url = linkedin_url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFounded() {
		return founded;
	}

	public void setFounded(int founded) {
		this.founded = founded;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLinkedin_url() {
		return linkedin_url;
	}

	public void setLinkedin_url(String linkedin_url) {
		this.linkedin_url = linkedin_url;
	}

	@Override
	public String toString() {
		return "Companies [id=" + id + ", website=" + website + ", name=" + name + ", founded=" + founded + ", size="
				+ size + ", locality=" + locality + ", region=" + region + ", country=" + country + ", industry="
				+ industry + ", linkedin_url=" + linkedin_url + "]";
	}
}