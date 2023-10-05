package com.Dynamiccode.medical.service;

import com.Dynamiccode.medical.dto.request.PatientRequest;

public interface PatientService {

    boolean savePatient(PatientRequest request);

}
