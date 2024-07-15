package com.hbn.c0323h1_2.services.impl;

import com.hbn.c0323h1_2.models.Student;
import com.hbn.c0323h1_2.repositories.IStudentRepository;
import com.hbn.c0323h1_2.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(Long idStudent) {
        return studentRepository.findById(idStudent);
    }

    @Override
    public void updateById(Long id, Student student) {
        studentRepository.updateById(id,student);
    }


}
