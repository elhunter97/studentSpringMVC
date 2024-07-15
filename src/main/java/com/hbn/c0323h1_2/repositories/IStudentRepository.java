package com.hbn.c0323h1_2.repositories;

import com.hbn.c0323h1_2.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Student findById(Long idStudent);

    void updateById(Long id, Student student);
}
