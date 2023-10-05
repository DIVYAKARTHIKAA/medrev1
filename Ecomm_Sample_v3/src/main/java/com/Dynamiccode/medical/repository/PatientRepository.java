package com.Dynamiccode.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dynamiccode.medical.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    void deleteByUserUid(Long uid);

}
