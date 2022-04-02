package com.yerbol.handbook.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yerbol.handbook.model.Speciality;
import com.yerbol.handbook.model.Student;
import com.yerbol.handbook.payload.request.SpecialityRequest;
import com.yerbol.handbook.payload.request.StudentRequest;
import com.yerbol.handbook.payload.response.MessageResponse;
import com.yerbol.handbook.payload.response.SpecialityResponse;
import com.yerbol.handbook.payload.response.StudentResponse;
import com.yerbol.handbook.service.SpecialityService;
import com.yerbol.handbook.service.StudentService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private SpecialityService specialityService;

	@GetMapping("/students")
	public ResponseEntity<?> findAllUsers() {
		List<Student> allStudents = studentService.findAll();

		List<StudentResponse> result = allStudents.stream().map(temp -> new StudentResponse(temp))
				.collect(Collectors.toList());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/students/search/findByName")
	public ResponseEntity<?> findByName(@RequestParam("name") String name) {
		List<Student> allStudents = studentService.findByName(name);

		List<StudentResponse> result = allStudents.stream().map(temp -> new StudentResponse(temp))
				.collect(Collectors.toList());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/students/search/findBySpeciality")
	public ResponseEntity<?> findBySpeciality(@RequestParam("speciality") String speciality) {
		List<Student> allStudents = studentService.findBySpeciality(speciality);

		List<StudentResponse> result = allStudents.stream().map(temp -> new StudentResponse(temp))
				.collect(Collectors.toList());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/students/search/findByPhoneNumber")
	public ResponseEntity<?> findByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
		Student student = studentService.findByPhoneNumber(phoneNumber);

		StudentResponse result = new StudentResponse(student);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/students/{id}")
	public ResponseEntity<?> setStudentProfile(@PathVariable("id") long id,
			@Valid @RequestBody StudentRequest studentRequest) {
		Student student = studentService.save(studentRequest, id);

		StudentResponse response = new StudentResponse(student);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
		studentService.deleteById(id);

		return ResponseEntity.ok(new MessageResponse("Student profile is deleted"));
	}

	@PostMapping("/speciality")
	public ResponseEntity<?> setSpeciality(@Valid @RequestBody SpecialityRequest specialityRequest) {
		Speciality speciality = specialityService.save(specialityRequest);

		SpecialityResponse response = new SpecialityResponse(speciality);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
