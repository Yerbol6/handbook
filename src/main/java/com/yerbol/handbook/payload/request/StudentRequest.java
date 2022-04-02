package com.yerbol.handbook.payload.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentRequest {

	@NotBlank
	@Size(min = 3, max = 20)
	private String firstName;

	@NotBlank
	@Size(min = 3, max = 20)
	private String lastName;

	private String patronymics;

	@NotBlank
	private Date birthDate;

	@NotBlank
	private String phoneNumber;

	@NotBlank
	@Size(min = 3, max = 20)
	private String speciality;

	public StudentRequest() {

	}

	public StudentRequest(String firstName, String lastName, String patronymics, Date birthDate,
			String phoneNumber, String speciality) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymics = patronymics;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.speciality = speciality;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymics() {
		return patronymics;
	}

	public void setPatronymics(String patronymics) {
		this.patronymics = patronymics;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

}
