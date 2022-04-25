package id.ac.uinsgd.springbootresetpassword.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Mata kuliah is required")
    @NotNull(message = "Mata kuliah can not be null!!")
    @Column(nullable = false, name = "course")
    private String course;

    @NotEmpty(message = "Tugas is required")
    @NotNull(message = "Tugas can not be null!!")
    @Column(nullable = false, name = "Tugas")
    private String task;
    
    @NotNull(message="Please enter deadline date")
    @FutureOrPresent(message="Deadline date should be least than current date!!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate deadlineDate;

    @NotEmpty(message = "Email Dosen is required")
    @Email
    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Hari number is required")
    @NotNull(message="Hari can not be null!")
    @Column(nullable = false)
    private String hari;

    @NotEmpty(message = "Pengumpulan is required")
    @Column(nullable=false)
    private String pengumpulan;
}