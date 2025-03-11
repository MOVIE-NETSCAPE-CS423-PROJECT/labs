package edu.miu.cs.cs425.mystudentmgmt;

import edu.miu.cs.cs425.mystudentmgmt.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmt.model.Course;
import edu.miu.cs.cs425.mystudentmgmt.model.Student;
import edu.miu.cs.cs425.mystudentmgmt.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmt.service.ClassroomService;
import edu.miu.cs.cs425.mystudentmgmt.service.CourseService;
import edu.miu.cs.cs425.mystudentmgmt.service.StudentService;
import edu.miu.cs.cs425.mystudentmgmt.service.TranscriptService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Collections;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {


    private final StudentService studentService;
    private final ClassroomService classroomService;
    private final CourseService courseService;
    private final TranscriptService transcriptService;

    public MyStudentMgmtAppApplication(StudentService studentService, ClassroomService classroomService, CourseService courseService, TranscriptService transcriptService) {
        this.studentService = studentService;
        this.classroomService = classroomService;
        this.courseService = courseService;
        this.transcriptService = transcriptService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        saveStudentWithTranscriptAndClassroom();
    }

    public void saveStudentWithTranscriptAndClassroom() {

        // Check if student already exists
        if (studentService.findByStudentNumber("000-61-0001").isPresent()) {
            System.out.println("Student already exists! Skipping insertion.");
            return;
        }
        // Create and Save Classroom
        Classroom classroom = new Classroom(null, "McLaughlin building", "M105");
        classroomService.saveClassroom(classroom);

        // Create and Save Student
        Student student1 = new Student(null, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24));
        student1.setClassroom(classroom);

        studentService.saveStudent(student1);

        // Create and Save Transcript
        Transcript transcript = new Transcript(null, "BS Computer Science", student1);
        transcriptService.saveTranscript(transcript);
        student1.setTranscript(transcript);
        studentService.saveStudent(student1);

        // Create and Save Course
        Course course1 = new Course(null, "CS401", "Modern Prog Practices");
        courseService.saveCourse(course1);

        // Assign Course to Student
        student1.setCourses(Collections.singletonList(course1));
        studentService.saveStudent(student1);

        System.out.println("Student, Transcript, Classroom, and Course saved successfully!");

    }


}
