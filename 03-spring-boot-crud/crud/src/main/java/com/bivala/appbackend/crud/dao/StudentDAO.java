package com.bivala.appbackend.crud.dao;

import com.bivala.appbackend.crud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findByID(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    Student update(Student theStudent);
    int updateWithQuery(String firstName,String lastName, Integer id);
    void delete(Integer id);
    int deleteAll();
}
