package edu.miu.csc425.davies.eregistrarwebapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateStudentRequest {


    private String studentNumber;


    private String firstName;


    private String middleName;


    private String lastName;


    private Double cgpa;


    private LocalDate enrollmentDate;


    private String isInternational;
}
