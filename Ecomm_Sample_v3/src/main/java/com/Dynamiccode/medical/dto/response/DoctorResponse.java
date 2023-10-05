package com.Dynamiccode.medical.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponse {
    private Long did;
    private String doctorName;
    private float doctorSalary;
    private Long yearsofExp;
    private String docDept;
    private String docSpec;
}
