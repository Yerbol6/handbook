package com.yerbol.handbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yerbol.handbook.model.Speciality;
import com.yerbol.handbook.payload.request.SpecialityRequest;
import com.yerbol.handbook.repository.SpecialityRepository;
import com.yerbol.handbook.service.SpecialityService;

@Service
public class SpecialityServiceImpl implements SpecialityService {

	@Autowired
	private SpecialityRepository specialityRepository;

	@Override
	public Speciality save(SpecialityRequest specialityRequest) {
		Speciality newSpeciality = mapToSpeciality(specialityRequest);

		Speciality existingSpeciality = specialityRepository.findByName(specialityRequest.getName()).orElse(null);
		if (existingSpeciality != null) {
			newSpeciality.setId(existingSpeciality.getId());
		}

		return specialityRepository.save(newSpeciality);
	}

	private Speciality mapToSpeciality(SpecialityRequest specialityRequest) {
		return new Speciality(specialityRequest.getName(), specialityRequest.getDescription());
	}

}
