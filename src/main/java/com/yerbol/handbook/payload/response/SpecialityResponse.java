package com.yerbol.handbook.payload.response;

import com.yerbol.handbook.model.Speciality;

public class SpecialityResponse {

	private Long id;
	private String name;
	private String description;

	public SpecialityResponse() {

	}

	public SpecialityResponse(Speciality speciality) {
		this.id = speciality.getId();
		this.name = speciality.getName();
		this.description = speciality.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
