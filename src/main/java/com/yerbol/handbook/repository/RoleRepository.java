package com.yerbol.handbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yerbol.handbook.model.Role;
import com.yerbol.handbook.model.RoleEnum;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(RoleEnum name);

}
