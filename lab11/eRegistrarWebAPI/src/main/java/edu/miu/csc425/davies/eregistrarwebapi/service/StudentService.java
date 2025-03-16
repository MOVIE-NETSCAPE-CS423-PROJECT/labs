package edu.miu.csc425.davies.eregistrarwebapi.service;

import edu.miu.csc425.davies.eregistrarwebapi.dto.request.CreateStudentRequest;
import edu.miu.csc425.davies.eregistrarwebapi.dto.request.UpdateStudentRequest;
import edu.miu.csc425.davies.eregistrarwebapi.dto.response.CreateStudentResponse;
import edu.miu.csc425.davies.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    CreateStudentResponse saveStudent(CreateStudentRequest createStudentRequest);
    Student getStudentById(Long id);
    UpdateStudentRequest updateStudent(Long id, UpdateStudentRequest updateStudentRequest);
    void deleteStudent(Long id);
}
