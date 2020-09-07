package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.entity.Student;
import com.thoughtworks.capability.gtb.entrancequiz.entity.Team;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class TeamService {

    private static final String PREFIX_OF_TEAM_NAME = "Team ";
    private static final int NUMBER_OF_TEAMS = 6;

    public List<Team> getRandomTeams() {
        List<Student> tempStudentList = new LinkedList<>(StudentRepository.findAll());

        List<Team> teamList = new LinkedList<>();
        int numberOfStudentsOfEachTeamExceptTheLastOne = tempStudentList.size() / NUMBER_OF_TEAMS + 1;
        int numberOfStudentsOfTheLastTeam = tempStudentList.size() % NUMBER_OF_TEAMS;

        for (int i = 0; i < NUMBER_OF_TEAMS - 1; i++) {
            teamList.add(new Team(PREFIX_OF_TEAM_NAME + (i + 1),
                    removeAndReturnARandomGroupOfStudentFromStudentList(tempStudentList,
                    numberOfStudentsOfEachTeamExceptTheLastOne)));
        }

        teamList.add(new Team(PREFIX_OF_TEAM_NAME + NUMBER_OF_TEAMS,
                removeAndReturnARandomGroupOfStudentFromStudentList(tempStudentList,
                numberOfStudentsOfTheLastTeam)));

        return teamList;

    }

    private Student[] removeAndReturnARandomGroupOfStudentFromStudentList(List<Student> studentList, int number) {
        Student[] studentArray = new Student[number];
        Random random = new Random();
        for (int j = 0; j < number; j++) {
            studentArray[j] = studentList.remove(random.nextInt(studentList.size()));
        }
        return studentArray;
    }
}
