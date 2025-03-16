package edu.miu.csc425.davies.eregistrarwebapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank(message = "Student number is required")
    @Column(name = "student_number", nullable = false, unique = true)
    private String studentNumber;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "cgpa")
    private Double cgpa;

    @NotNull()
    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @NotBlank(message = "International status is required")
    @Column(name = "is_international", nullable = false)
    private String isInternational;

}
