package ru.gb.oseminar.service;

import ru.gb.oseminar.data.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {

    private List<Teacher> teachers = new ArrayList<>();
    private Long nextId = 1L;

    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Teacher teacher = new Teacher(firstName, secondName, patronymic, dateOfBirth);
        teacher.setTeacherId(nextId++);
        teachers.add(teacher);
    }

    public List<Teacher> getAll() {
        return teachers;
    }

    public Teacher getById(Long id) {
        return teachers.stream().filter(teacher -> teacher.getTeacherId().equals(id)).findFirst().orElse(null);
    }

    public void update(Teacher teacher) {
    }
}

