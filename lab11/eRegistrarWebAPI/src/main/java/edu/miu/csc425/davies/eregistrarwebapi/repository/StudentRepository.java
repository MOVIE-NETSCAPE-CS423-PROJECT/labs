package edu.miu.csc425.davies.eregistrarwebapi.repository;

import edu.miu.csc425.davies.eregistrarwebapi.model.Student;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByStudentNumber(String studentNumber);
}
