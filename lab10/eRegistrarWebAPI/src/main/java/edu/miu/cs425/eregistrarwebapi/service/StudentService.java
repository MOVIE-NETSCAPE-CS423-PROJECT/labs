package edu.miu.cs425.eregistrarwebapi.service;


import edu.miu.cs425.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void deleteStudentById(Long id);

    List<Student> searchStudents(String keyword);
}
