package com.thoughtworks.capability.gtb.entrancequiz.entity;

public class Team {

    private String teamName;
    private Student[] students;

    public Team(String teamName, Student[] students) {
        this.teamName = teamName;
        this.students = students;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
