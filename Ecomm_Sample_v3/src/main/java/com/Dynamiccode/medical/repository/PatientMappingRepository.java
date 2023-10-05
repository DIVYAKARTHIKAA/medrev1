package com.Dynamiccode.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dynamiccode.medical.model.PatientMapping;

public interface PatientMappingRepository extends JpaRepository<PatientMapping, Long> {

}
