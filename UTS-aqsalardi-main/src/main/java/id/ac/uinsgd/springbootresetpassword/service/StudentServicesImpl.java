package id.ac.uinsgd.springbootresetpassword.service;

import id.ac.uinsgd.springbootresetpassword.entity.Student;
import id.ac.uinsgd.springbootresetpassword.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServicesImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student save(Student newStd){
        return studentRepository.save(newStd);
    }

    @Override
    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }
}