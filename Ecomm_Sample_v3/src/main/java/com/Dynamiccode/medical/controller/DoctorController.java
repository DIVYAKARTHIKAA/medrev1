package com.Dynamiccode.medical.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dynamiccode.medical.constant.Api;
import com.Dynamiccode.medical.dto.request.DoctorRequest;
import com.Dynamiccode.medical.dto.response.DoctorResponse;
import com.Dynamiccode.medical.service.DoctorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.DOCTOR)
@RequiredArgsConstructor
@Tag(name = "Doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/save")
    public ResponseEntity<String> saveDoctor(@RequestBody DoctorRequest request) {
        boolean isSaved = doctorService.saveDoctor(request);
        return isSaved ? ResponseEntity.status(201).body("Doctor added successfully!")
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        List<DoctorResponse> doctorList = doctorService.getAllDoctors();
        return !doctorList.isEmpty() ? ResponseEntity.status(200).body(doctorList)
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/{did}")
    public ResponseEntity<DoctorResponse> getDoctor(@PathVariable Long did) {
        DoctorResponse doctorResponse = doctorService.getDoctor(did);
        return doctorResponse != null ? ResponseEntity.ok().body(doctorResponse) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{did}")
    public ResponseEntity<DoctorResponse> updateDoctor(@RequestBody DoctorRequest request, @PathVariable Long did) {
        DoctorResponse doctorResponse = doctorService.updateDoctor(request, did);
        return doctorResponse != null ? ResponseEntity.ok().body(doctorResponse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{did}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long did) {
        boolean isDeleted = doctorService.deleteDoctor(did);
        return isDeleted ? ResponseEntity.ok().body("Doctor deleted successfully!")
                : ResponseEntity.notFound().build();
    }

}
