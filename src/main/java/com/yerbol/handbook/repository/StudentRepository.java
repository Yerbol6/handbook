package com.yerbol.handbook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yerbol.handbook.model.Speciality;
import com.yerbol.handbook.model.Student;
import com.yerbol.handbook.model.User;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByUser(User user);

	@Query("Select s from Student s where s.firstName like %:name% or s.lastName like %:name% or s.patronymics like %:name%")
	List<Student> findByName(@Param("name") String name);

	Optional<Student> findByPhoneNumber(String phoneNumber);

	List<Student> findBySpeciality(Speciality speciality);

}
