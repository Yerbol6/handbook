package com.yerbol.handbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yerbol.handbook.model.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

	Optional<Speciality> findByName(String name);

}
