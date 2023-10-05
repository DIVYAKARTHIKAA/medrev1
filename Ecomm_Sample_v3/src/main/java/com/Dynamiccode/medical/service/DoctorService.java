package com.Dynamiccode.medical.service;

import java.util.List;

import com.Dynamiccode.medical.dto.request.DoctorRequest;
import com.Dynamiccode.medical.dto.response.DoctorResponse;
import com.Dynamiccode.medical.model.Doctor;

public interface DoctorService {

    boolean saveDoctor(DoctorRequest request);

    List<DoctorResponse> getAllDoctors();

    DoctorResponse getDoctor(Long did);

    DoctorResponse updateDoctor(DoctorRequest request, Long did);

    boolean deleteDoctor(Long did);

    Doctor getDoctorModelId(Long did);

}
