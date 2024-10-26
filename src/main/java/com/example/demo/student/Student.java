package com.example.demo.student;

import jakarta.persistence.*; //make sure if we change hibernate to another provider, it will still work.
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.time.Period;

@Entity //indicates that the class is a JPA entity.
@Table //Specifies the table name in the database(@Table(name = "students") => if not default to class name)
public class Student {

    @Id //denotes the primary key of the table
    @SequenceGenerator(
            name = "student_sequence", //for generated value annotation
            sequenceName = "student_sequence",
            allocationSize = 1 //increment by
    )
    @GeneratedValue( //specifies how the primary key is generated
            strategy = GenerationType.SEQUENCE,
            generator =  "student_sequence" //actual database sequence
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
