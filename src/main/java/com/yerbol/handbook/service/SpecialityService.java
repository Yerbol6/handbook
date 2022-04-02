package com.yerbol.handbook.service;

import com.yerbol.handbook.model.Speciality;
import com.yerbol.handbook.payload.request.SpecialityRequest;

public interface SpecialityService {

	Speciality save(SpecialityRequest specialityRequest);

}
