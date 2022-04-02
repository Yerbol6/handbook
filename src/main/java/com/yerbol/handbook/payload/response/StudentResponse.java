package com.yerbol.handbook.payload.response;

import java.util.Date;

import com.yerbol.handbook.model.Student;

public class StudentResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String patronymics;
	private Date birthDate;
	private Date registrationDate;
	private String phoneNumber;
	private String speciality;

	public StudentResponse(Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.patronymics = student.getPatronymics();
		this.birthDate = student.getBirthDate();
		this.registrationDate = student.getRegistrationDate();
		this.phoneNumber = student.getPhoneNumber();
		this.speciality = (student.getSpeciality() != null) ? student.getSpeciality().getName() : null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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
