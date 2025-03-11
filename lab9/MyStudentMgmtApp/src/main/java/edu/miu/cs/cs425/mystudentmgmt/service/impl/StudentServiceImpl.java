package edu.miu.cs.cs425.mystudentmgmt.service.impl;


import edu.miu.cs.cs425.mystudentmgmt.model.Student;
import edu.miu.cs.cs425.mystudentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.mystudentmgmt.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> findByStudentNumber(String s) {
        return studentRepository.findByStudentNumber(s);
    }
}
