package edu.miu.csc425.davies.eregistrarwebapi.service.impl;

import edu.miu.csc425.davies.eregistrarwebapi.dto.request.CreateStudentRequest;
import edu.miu.csc425.davies.eregistrarwebapi.dto.request.UpdateStudentRequest;
import edu.miu.csc425.davies.eregistrarwebapi.dto.response.CreateStudentResponse;
import edu.miu.csc425.davies.eregistrarwebapi.model.Student;
import edu.miu.csc425.davies.eregistrarwebapi.repository.StudentRepository;
import edu.miu.csc425.davies.eregistrarwebapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public CreateStudentResponse saveStudent(CreateStudentRequest createStudentRequest) {

        studentRepository.findStudentByStudentNumber(createStudentRequest.getStudentNumber()).ifPresent(student -> {
            throw new RuntimeException("Student already exists");
        });

        Student student = new Student();
        student.setStudentNumber(createStudentRequest.getStudentNumber());
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setMiddleName(createStudentRequest.getMiddleName());
        student.setCgpa(createStudentRequest.getCgpa());
        student.setEnrollmentDate(createStudentRequest.getEnrollmentDate());
        student.setIsInternational(createStudentRequest.getIsInternational());

        Student savedStudent = studentRepository.save(student);
        return CreateStudentResponse.builder().studentNumber(savedStudent.getStudentNumber())
                .firstName(savedStudent.getFirstName()).lastName(savedStudent.getLastName())
                .middleName(savedStudent.getMiddleName())
                .cgpa(savedStudent.getCgpa())
                .enrollmentDate(savedStudent.getEnrollmentDate())
                .isInternational(savedStudent.getIsInternational())
                .studentNumber(student.getStudentNumber())
                .build();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public UpdateStudentRequest updateStudent(Long id, UpdateStudentRequest student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);


        if (existingStudent != null) {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setMiddleName(student.getMiddleName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setCgpa(student.getCgpa());

            existingStudent.setEnrollmentDate(student.getEnrollmentDate());
            existingStudent.setIsInternational(student.getIsInternational());
            studentRepository.save(existingStudent);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
