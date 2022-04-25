package id.ac.uinsgd.springbootresetpassword.controller;

import id.ac.uinsgd.springbootresetpassword.entity.Student;
import id.ac.uinsgd.springbootresetpassword.exception.StudentNotFoundException;
import id.ac.uinsgd.springbootresetpassword.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController{
    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studentservice){
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentservice.getAllStudents();
    }

    @GetMapping(value="/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) Long id){
        Student std = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is not found!"));
        return std;
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student std){
        return studentservice.save(std);
    }
    
    @PutMapping(value="/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Student newStd){
        Student student = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        student.setCourse(newStd.getCourse());
        student.setTask(newStd.getTask());
        student.setEmail(newStd.getEmail());
        student.setHari(newStd.getHari());
        return studentservice.save(student);
    }

    @DeleteMapping(value="/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id){
        Student std = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id +" is not found!"));
        studentservice.deleteById(std.getId());
        return "Student with ID :"+ id +" is deleted!";
    }
}