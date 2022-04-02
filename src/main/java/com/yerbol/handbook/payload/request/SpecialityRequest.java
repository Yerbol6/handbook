package com.yerbol.handbook.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SpecialityRequest {

	@NotBlank
	@Size(max = 20)
	private String name;

	@NotBlank
	private String description;

	public SpecialityRequest() {

	}

	public SpecialityRequest(String name, String description) {
		this.name = name;
		this.description = description;
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
