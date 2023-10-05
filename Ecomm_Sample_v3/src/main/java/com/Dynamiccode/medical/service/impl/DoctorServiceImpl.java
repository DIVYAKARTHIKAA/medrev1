package com.Dynamiccode.medical.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Dynamiccode.medical.dto.request.DoctorRequest;
import com.Dynamiccode.medical.dto.response.DoctorResponse;
import com.Dynamiccode.medical.model.Doctor;
import com.Dynamiccode.medical.repository.DoctorRepository;
import com.Dynamiccode.medical.service.DoctorService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public boolean saveDoctor(DoctorRequest request) {
        if (doctorRepository.findByDoctorName(request.getDoctorName()).isPresent()) {
            return false;
        }

        Doctor doctor = Doctor.builder()
                .doctorName(request.getDoctorName())
                .doctorSalary(request.getDoctorSalary())
                .yearsofExp(request.getYearsofExp())
                .docDept(request.getDocDept())
                .docSpec(request.getDocSpec())
                .build();

        doctorRepository.save(doctor);
        return true;
    }

    @Override
    public List<DoctorResponse> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();

        return doctorList.stream()
                .map(this::mapDoctorToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorResponse getDoctor(Long did) {
        Doctor doctor = doctorRepository.findByDid(did);
        return mapDoctorToResponse(doctor);
    }

    @Override
    public DoctorResponse updateDoctor(DoctorRequest request, Long did) {
        Doctor doctor = doctorRepository.findByDid(did);

        if (doctor != null) {
            doctor.setDoctorName(request.getDoctorName());
            doctor.setDoctorSalary(request.getDoctorSalary());
            doctor.setYearsofExp(request.getYearsofExp());
            doctor.setDocDept(request.getDocDept());
            doctor.setDocSpec(request.getDocSpec());

            doctorRepository.save(doctor);

            return mapDoctorToResponse(doctor);
        } else {
            throw new EntityNotFoundException("Doctor with did " + did + " not found");
        }
    }

    @Override
    public boolean deleteDoctor(Long did) {
        Doctor doctor = doctorRepository.findByDid(did);

        if (doctor != null) {
            doctorRepository.deleteByDid(did);
            return true;
        } else {
            return false;
        }
    }

    private DoctorResponse mapDoctorToResponse(Doctor doctor) {
        return DoctorResponse.builder()
                .did(doctor.getDid())
                .doctorName(doctor.getDoctorName())
                .doctorSalary(doctor.getDoctorSalary())
                .yearsofExp(doctor.getYearsofExp())
                .docDept(doctor.getDocDept())
                .docSpec(doctor.getDocSpec())
                .build();
    }

    @Override
    public Doctor getDoctorModelId(Long did) {
        return doctorRepository.findByDid(did);
    }
}
