package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.entity.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public StudentService() {
        StudentRepository.initialStudentList();
    }

    public List<Student> getStudentList() {
        return StudentRepository.findAll();
    }

    public void addStudent(String studentName) {
        StudentRepository.addStudent(studentName);
    }
}
