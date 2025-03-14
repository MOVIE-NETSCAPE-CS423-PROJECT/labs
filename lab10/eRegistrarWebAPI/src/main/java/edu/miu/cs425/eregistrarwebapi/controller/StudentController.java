package edu.miu.cs425.eregistrarwebapi.controller;

import edu.miu.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs425.eregistrarwebapi.model.isInternational;
import edu.miu.cs425.eregistrarwebapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller
//@RequestMapping("/students")
//public class StudentController {
//
//    private final StudentService studentService;
//
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//    @GetMapping
//    public String listStudents(Model model) {
//        model.addAttribute("students", studentService.getAllStudents());
//        return "list";
//    }
//
//    @GetMapping("/new")
//    public String showCreateStudentForm(Model model) {
//        model.addAttribute("student", new Student());
//        return "form";
//    }
//
//    @PostMapping()
//    public String saveStudent(@ModelAttribute Student student) {
//        studentService.addStudent(student);
//        return "redirect:/students";
//    }
//    @GetMapping("/edit/{id}")
//    public String showEditStudentForm(@PathVariable Long id, Model model) {
//        model.addAttribute("student", studentService.getStudentById(id));
//        return "form";
//    }
//
//    @PostMapping("/{id}")
//    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
//        student.setStudentId(id);
//        studentService.addStudent(student);
//        return "redirect:/students";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudentById(id);
//        return "redirect:/students";
//    }
//
//
//    @GetMapping("/search")
//    public String searchStudents(@RequestParam String keyword, Model model) {
//        model.addAttribute("students", studentService.searchStudents(keyword));
//        return "list";
//    }
//
//
//
//}


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Display the list of students
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";  // Return Thymeleaf template "list.html"
    }

    // Show student registration form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";  // Return "form.html" for new student entry
    }

    // Handle new student submission
    @PostMapping
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "students/form";  // If validation fails, reload form
        }
        if (student.getIsInternational() == null) {
            student.setIsInternational(isInternational.valueOf("no"));  // Default to "No" if not provided
        }
        studentService.addStudent(student);
        return "redirect:/students";  // Redirect to list after saving
    }


    // Show edit form for an existing student
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return "redirect:/students";  // Redirect if student not found
        }
        model.addAttribute("student", student);
        return "students/form";  // Return edit form
    }

    // Handle student update
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "students/form";  // If validation fails, reload form
        }
        student.setStudentId(id);  // Ensure correct ID is set
        studentService.addStudent(student);
        return "redirect:/students";  // Redirect to student list
    }

    // Delete a student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";  // Redirect after deletion
    }

    // Search students by first name
    @GetMapping("/search")
    public String searchStudents(@RequestParam("keyword") String keyword, Model model) {
        List<Student> searchResults = studentService.searchStudents(keyword);
        model.addAttribute("students", searchResults);
        return "students/list";  // Return list view with search results
    }
}
