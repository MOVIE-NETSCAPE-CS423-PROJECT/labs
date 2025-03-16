package edu.miu.csc425.davies.eregistrarwebapi.controller;

import edu.miu.csc425.davies.eregistrarwebapi.dto.request.CreateStudentRequest;
import edu.miu.csc425.davies.eregistrarwebapi.dto.response.CreateStudentResponse;
import edu.miu.csc425.davies.eregistrarwebapi.model.Student;
import edu.miu.csc425.davies.eregistrarwebapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eregistrar/api/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/list")
    public List<Student> listStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/register")
    public ResponseEntity<CreateStudentResponse> register(@RequestBody CreateStudentRequest createStudentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(createStudentRequest));
    }

    @GetMapping("/get/{studentNumber}")
    public Student getStudentId(@PathVariable Long studentNumber) {
        return studentService.getStudentById(studentNumber);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
