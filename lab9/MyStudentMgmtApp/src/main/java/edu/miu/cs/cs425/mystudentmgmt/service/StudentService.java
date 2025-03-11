package edu.miu.cs.cs425.mystudentmgmt.service;

import edu.miu.cs.cs425.mystudentmgmt.model.Student;

import java.util.Optional;

public interface StudentService {

    public void saveStudent(Student student);

    Optional<Student> findByStudentNumber(String s);
}
