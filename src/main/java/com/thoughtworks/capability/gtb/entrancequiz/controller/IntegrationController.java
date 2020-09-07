package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.entity.Student;
import com.thoughtworks.capability.gtb.entrancequiz.entity.Team;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import com.thoughtworks.capability.gtb.entrancequiz.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:1234")
public class IntegrationController {

    private final StudentService studentService;
    private final TeamService teamService;

    public IntegrationController(StudentService studentService, TeamService teamService) {
        this.studentService = studentService;
        this.teamService = teamService;
    }

    @GetMapping("/students")
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }

    @GetMapping("/teams")
    public List<Team> getRandomTeams() {
        return teamService.getRandomTeams();
    }

    @PostMapping("/students")
    public ResponseEntity<ResponseEntity.BodyBuilder> addStudent(@RequestBody String studentName) {
        studentService.addStudent(studentName);
        return ResponseEntity.ok().build();
    }

}
