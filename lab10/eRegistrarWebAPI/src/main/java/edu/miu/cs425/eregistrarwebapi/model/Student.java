package edu.miu.cs425.eregistrarwebapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

//isInternational: (values: "Yes", "No") (required) - Hint: Implement/present this data in a drop-down list or Radio button

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false, unique = true)
    private String studentNumber;

    @NotNull(message = "student name can not be null")
    @NotEmpty(message = "student name can not be empty")
    @NotBlank(message = "student name can not be blank")
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private double cgpa;

    @Column(nullable = false)
    private LocalDate enrollmentDate;

    @Column(nullable = false)
    private isInternational isInternational;


    public Student(Long studentId, String studentNumber, String firstName, String middleName, String lastName, double cgpa, LocalDate enrollmentDate, isInternational isInternational) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }


}
