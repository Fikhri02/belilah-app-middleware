package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());

        if(studentEmail.isPresent()){
            throw new IllegalStateException("Email Existed");
        }

        studentRepository.save(student);

        return student;

    }

    public void deleteStudent(Long id) {
        boolean exist = studentRepository.existsById(id);
        if(!exist){
            throw new InputMismatchException("ID does not exist");
        }
        studentRepository.deleteById(id);
    }
}
