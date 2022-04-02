package com.yerbol.handbook.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "student", uniqueConstraints = { @UniqueConstraint(columnNames = "phone_number"),
		@UniqueConstraint(columnNames = { "first_name", "last_name", "patronymics" }) })
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Size(max = 20)
	@Column(name = "last_name")
	private String lastName;

	@Size(max = 20)
	@Column(name = "patronymics")
	private String patronymics;

	@CreationTimestamp
	@Column(name = "registration_date")
	private Date registrationDate;

	@Column(name = "birth_date")
	private Date birthDate;

	@Size(max = 20)
	@Column(name = "phone_number")
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "speciality_id")
	private Speciality speciality;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Student() {

	}

	public Student(String firstName, String lastName, String patronymics, Date registrationDate, Date birthDate,
			String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymics = patronymics;
		this.registrationDate = registrationDate;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
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

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
