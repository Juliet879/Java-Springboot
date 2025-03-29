package com.gisemba.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.email);

        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Boolean exist = studentRepository.existsById(studentId);

        if(!exist) {
            throw new IllegalStateException("Student with id:" + studentId + "Does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}
