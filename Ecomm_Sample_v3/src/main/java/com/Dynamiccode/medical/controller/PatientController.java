package com.Dynamiccode.medical.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dynamiccode.medical.constant.Api;
import com.Dynamiccode.medical.dto.request.PatientRequest;
import com.Dynamiccode.medical.service.PatientService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.PATIENT)
@RequiredArgsConstructor
@Tag(name = "Patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/save")
    public ResponseEntity<String> savePatient(@RequestBody PatientRequest request) {
        boolean isSaved = patientService.savePatient(request);
        return isSaved ? ResponseEntity.status(200).body("Patient saved successfully!")
                : ResponseEntity.badRequest().build();
    }
}
