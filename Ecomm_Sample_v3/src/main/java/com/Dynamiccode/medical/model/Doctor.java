package com.Dynamiccode.medical.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_doc")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;

    @Column(length = 250, nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private float doctorSalary;

    @Column(nullable = false)
    private Long yearsofExp;

    @Column(nullable = false)
    private String docDept;

    @Column(length = 50000, nullable = true)
    private String docSpec;
}
