package com.hbn.c0323h1_2.repositories.impl;

import com.hbn.c0323h1_2.models.Student;
import com.hbn.c0323h1_2.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    static{
        students.add(new Student(1L,"Han Bao Ngoc","HN",9.0f));
        students.add(new Student(2L,"Tran Thi Khanh Linh","BN",9.5f));
        students.add(new Student(3L,"Han Tran Tung Anh","HN",9.9f));

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size()-1).getId()+1);
        students.add(student);
    }

    @Override
    public Student findById(Long idStudent) {
        for(Student student : students){
            if(student.getId() == idStudent){
                return student;
            }
        }
        return null;
    }

    @Override
    public void updateById(Long id, Student student) {
        Student studentUpdate = findById(id);
        studentUpdate.setName(student.getName());
        studentUpdate.setAddress(student.getAddress());
        studentUpdate.setPoint(student.getPoint());
    }
}
