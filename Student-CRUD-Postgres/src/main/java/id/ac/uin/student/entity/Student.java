package id.ac.uin.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "First name is required")
    @NotNull(message = "FirstName can not be null!!")
    @Column(nullable = false, name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @NotNull(message = "Last Name can not be null!!")
    @Column(nullable = false, name = "last_name")
    private String lastName;

    @NotNull(message = "Please enter your Birth date!")
    @Past(message = "Birth date should be less than current date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotEmpty(message = "email is required")
    @NotNull(message = "email can not be null!!")
    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @NotEmpty(message = "phone number is required")
    @NotNull(message = "phone number can not be null!!")
    @Column(nullable = false, name = "phone_number", unique = true)
    private String phoneNumber;

    @NotEmpty(message = "jurusan is required")
    @NotNull(message = "jurusan can not be null!!")
    @Column(nullable = false, name = "jurusan", unique = true)
    private String jurusan;

}
