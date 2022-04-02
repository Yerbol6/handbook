package com.yerbol.handbook.rest;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yerbol.handbook.model.Student;
import com.yerbol.handbook.payload.request.StudentRequest;
import com.yerbol.handbook.payload.response.StudentResponse;
import com.yerbol.handbook.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/get-student-profile")
	public ResponseEntity<?> getStudentProfile(Principal principal) {
		Student student = studentService.findByUsername(principal.getName());

		StudentResponse response = new StudentResponse(student);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/set-student-profile")
	public ResponseEntity<?> setStudentProfile(Principal principal, @Valid @RequestBody StudentRequest studentRequest) {
		Student student = studentService.save(studentRequest, principal.getName());

		StudentResponse response = new StudentResponse(student);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
