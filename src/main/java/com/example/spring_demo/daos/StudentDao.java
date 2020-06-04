package com.example.spring_demo.daos;

import com.example.spring_demo.models.Student;

import java.util.List;

public interface StudentDao {
    //CRUD
    Student create(Student student);//C
    Student findById(int id);       //R
    List<Student> getAll();      //R
    Student update(Student student);//U
    void delete(Student student);   //D

}
