package com.yerbol.handbook.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yerbol.handbook.model.Speciality;
import com.yerbol.handbook.model.Student;
import com.yerbol.handbook.model.User;
import com.yerbol.handbook.payload.request.StudentRequest;
import com.yerbol.handbook.repository.SpecialityRepository;
import com.yerbol.handbook.repository.StudentRepository;
import com.yerbol.handbook.repository.UserRepository;
import com.yerbol.handbook.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SpecialityRepository specialityRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Student> findAll() {
		List<Student> allStudents = studentRepository.findAll();

		if (allStudents == null || allStudents.size() == 0) {
			throw new EntityNotFoundException("Students not found");
		}

		return allStudents;
	}

	@Override
	public List<Student> findByName(String name) {
		List<Student> students = studentRepository.findByName(name);

		if (students == null || students.size() == 0) {
			throw new EntityNotFoundException("Students with name like: " + name + " not found");
		}

		return students;
	}

	@Override
	public Student findByUsername(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new EntityNotFoundException("User with username: " + username + " not found"));
		Student student = studentRepository.findByUser(user)
				.orElseThrow(() -> new EntityNotFoundException("Student profile of user: " + user + " not found"));
		return student;
	}

	@Override
	public Student findByPhoneNumber(String phoneNumber) {
		return studentRepository.findByPhoneNumber(phoneNumber).orElseThrow(
				() -> new EntityNotFoundException("Student with phone number: " + phoneNumber + " not found"));
	}

	@Override
	public List<Student> findBySpeciality(String speciality) {
		Speciality existingSpeciality = specialityRepository.findByName(speciality)
				.orElseThrow(() -> new EntityNotFoundException("Speciality with name: " + speciality + " not found"));

		List<Student> students = studentRepository.findBySpeciality(existingSpeciality);
		if (students == null || students.size() == 0) {
			throw new EntityNotFoundException("Students with speciality: " + speciality + " not found");
		}

		return students;
	}

	@Override
	public Student save(StudentRequest studentRequest, String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new EntityNotFoundException("User with username: " + username + " not found"));
		Speciality speciality = specialityRepository.findByName(studentRequest.getSpeciality())
				.orElse(new Speciality(studentRequest.getSpeciality(), null));
		if (speciality.getId() == 0) {
			speciality = specialityRepository.save(speciality);
		}

		Student newStudent = mapToStudent(studentRequest);
		newStudent.setUser(user);
		newStudent.setSpeciality(speciality);

		Student exitingStudent = studentRepository.findByUser(user).orElse(null);
		if (exitingStudent != null) {
			newStudent.setId(exitingStudent.getId());
			newStudent.setRegistrationDate(exitingStudent.getRegistrationDate());
		}
		return studentRepository.save(newStudent);
	}

	@Override
	public void deleteById(Long id) {
		if (!studentRepository.existsById(id)) {
			throw new EntityNotFoundException("Students with id: " + id + " not found");
		}
		studentRepository.deleteById(id);
	}

	@Override
	public Student save(StudentRequest studentRequest, long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new EntityNotFoundException("User with id: " + userId + " not found"));
		Speciality speciality = specialityRepository.findByName(studentRequest.getSpeciality())
				.orElse(new Speciality(studentRequest.getSpeciality(), null));
		if (speciality.getId() == 0) {
			speciality = specialityRepository.save(speciality);
		}

		Student newStudent = mapToStudent(studentRequest);
		newStudent.setUser(user);
		newStudent.setSpeciality(speciality);

		Student exitingStudent = studentRepository.findByUser(user).orElse(null);
		if (exitingStudent != null) {
			newStudent.setId(exitingStudent.getId());
			newStudent.setRegistrationDate(exitingStudent.getRegistrationDate());
		}
		return studentRepository.save(newStudent);
	}

	private Student mapToStudent(StudentRequest studentRequest) {
		return new Student(studentRequest.getFirstName(), studentRequest.getLastName(), studentRequest.getPatronymics(),
				new Date(), studentRequest.getBirthDate(), studentRequest.getPhoneNumber());
	}

}
