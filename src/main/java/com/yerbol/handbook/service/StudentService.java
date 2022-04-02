package com.yerbol.handbook.service;

import java.util.List;

import com.yerbol.handbook.model.Student;
import com.yerbol.handbook.payload.request.StudentRequest;

public interface StudentService {

	public List<Student> findAll();

	public List<Student> findByName(String name);

	public Student findByPhoneNumber(String phoneNumber);

	public List<Student> findBySpeciality(String speciality);

	public Student findByUsername(String username);

	public Student save(StudentRequest studentRequest, String username);

	public Student save(StudentRequest studentRequest, long userId);

	public void deleteById(Long id);

}
