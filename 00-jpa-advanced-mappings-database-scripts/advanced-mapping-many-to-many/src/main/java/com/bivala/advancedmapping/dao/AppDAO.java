package com.bivala.advancedmapping.dao;

import com.bivala.advancedmapping.entity.Course;
import com.bivala.advancedmapping.entity.Instructor;
import com.bivala.advancedmapping.entity.InstructorDetail;
import com.bivala.advancedmapping.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorByID(int theId);
    InstructorDetail findInstructorDetailByID(int theId);

    void deleteInstructorByID(int theId);

    void deleteInstructorDetailByID(int theId);
    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorByJoinFetch(int theId);
    void update(Instructor tempInstructor);
    void update (Course tempCourse);
    Course findCourseById(int theId);
    Instructor delete(int theId);
    void deleteCourseById(int theId);
    void save(Course theCourse);
    Course findCourseAndReviewsByCourseId(int theId);
    Course findCourseAndStudentsByCourseId(int theId);
    Student findStudentAndCoursesByStudentId(int theId);
    void update(Student tempStudent);
    void deleteStudentById(int theId);
}
