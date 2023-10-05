package com.Dynamiccode.medical.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dynamiccode.medical.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByDoctorName(String doctorName);

    Doctor findByDid(Long did);

    void deleteByDid(Long did);

}
