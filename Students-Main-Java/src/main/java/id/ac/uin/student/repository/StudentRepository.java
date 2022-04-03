package id.ac.uin.student.repository;

import id.ac.uin.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Optional<Student> findById(Long id);

    Optional<Student> findByEmail(String email);

    Student save(Student std);

    void deleteById(Long id);
}
