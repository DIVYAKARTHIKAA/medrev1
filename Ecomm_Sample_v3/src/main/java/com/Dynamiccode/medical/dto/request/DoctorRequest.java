package com.Dynamiccode.medical.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequest {
    private String doctorName;
    private float doctorSalary;
    private Long yearsofExp;
    private String docDept;
    private String docSpec;
}
