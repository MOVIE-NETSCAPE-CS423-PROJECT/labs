package edu.miu.cs425.eregistrarwebapi;

import edu.miu.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs425.eregistrarwebapi.model.isInternational;
import edu.miu.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ERegistrarWebApiApplication implements CommandLineRunner {

    private StudentService studentService;

    public ERegistrarWebApiApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarWebApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //addStudent();
        //deleteStudentById(1l);
        //getAllStudents();
        //findByFirstNameContaining("");
    }

    public void addStudent() {
        Student student1 = new Student( null, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24), isInternational.yes);
        studentService.addStudent(student1);

        Student student2 = new Student( null, "111-61-0001", "John", null, "Doe", 3.8, LocalDate.of(2020, 6, 16),isInternational.no);

        studentService.addStudent(student2);
        System.out.println(student1);
        System.out.println(student2);
    }

    public void getStudentById(Long id) {
        Student student = studentService.getStudentById(id);
        System.out.println(student);
    }

    public void getAllStudents() {
        var students  =  studentService.getAllStudents();
        students.forEach(System.out::println);
    }

    public void deleteStudentById(Long id) {
        studentService.deleteStudentById(id);
    }

    public void findByFirstNameContaining(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            System.out.println("Empty keyword");
        }

        List<Student> foundStudents = studentService.searchStudents("John");
        foundStudents.forEach(System.out::println);
    }
}
