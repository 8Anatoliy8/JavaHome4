package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.service.TeacherService;
import ru.gb.oseminar.view.TeacherView;

import java.time.LocalDate;
import java.util.List;

public class TeacherController {
    private final TeacherService teacherService = new TeacherService();
    private final TeacherView teacherView = new TeacherView();

    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        teacherService.create(firstName, secondName, patronymic, dateOfBirth);
        teacherView.sendOnConsole(teacherService.getAll());
    }

    public void updateTeacher(Long teacherId, String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Teacher teacher = teacherService.getById(teacherId);
        if (teacher != null) {
            teacher.setFirstName(firstName);
            teacher.setSecondName(secondName);
            teacher.setPatronymic(patronymic);
            teacher.setDateOfBirth(dateOfBirth);
            teacherService.update(teacher);
            teacherView.sendOnConsole(teacherService.getAll());
        } else {
            throw new IllegalArgumentException("Учитель с таким ID не найден");
        }
    }

    public void getAllTeachers() {
        List<Teacher> teachers = teacherService.getAll();
        teacherView.sendOnConsole(teachers);
    }
}
