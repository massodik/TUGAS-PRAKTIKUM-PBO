package id.ac.uin.student.controller;

import id.ac.uin.student.entity.Student;
import id.ac.uin.student.exception.StudentNotFoundException;
import id.ac.uin.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/students") //alamat yang akan kita tuju
public class StudentController {
    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentservice.getAllStudents();
    } //menampilkan student

    //menampilkan student
    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) Long id) {
        Student std = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        return std;
    }

    //menambahkan student
    //method = addStudent
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student std) {
        return studentservice.save(std);
    }

    //update student
    @PutMapping(value = "/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Student newStd) {
        Student student = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        student.setFirstName(newStd.getFirstName());
        student.setLastName(newStd.getLastName());
        student.setEmail(newStd.getEmail());
        student.setPhone(newStd.getPhone());
        return studentservice.save(student);
    }

    //delete student
    @DeleteMapping(value = "/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id) {
        Student std = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        studentservice.deleteById(std.getId());
        return "Student with ID :" + id + " is deleted";
    }
}
