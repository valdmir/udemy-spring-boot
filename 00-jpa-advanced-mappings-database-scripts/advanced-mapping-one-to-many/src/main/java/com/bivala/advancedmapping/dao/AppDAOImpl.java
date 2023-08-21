package com.bivala.advancedmapping.dao;

import com.bivala.advancedmapping.entity.Course;
import com.bivala.advancedmapping.entity.Instructor;
import com.bivala.advancedmapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
//    define field for entity manager
    private EntityManager entityManager;
//    inject entity manager
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorByID(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    public InstructorDetail findInstructorDetailByID(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorByID(int theId) {
        Instructor instructor=entityManager.find(Instructor.class,theId);
//        get the courses
        List<Course> courses=instructor.getCourses();
//        break asssociatioin of all courses for the instructor
        for(Course temp:courses){
            temp.setInstructor(null);
        }
//        delete the instructor
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailByID(int theId) {
        InstructorDetail tempDetail=entityManager.find(InstructorDetail.class,theId);
        tempDetail.getInstructor().setInstructorDetail(null);
//        break bi directional
        entityManager.remove(tempDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery("FROM Course where instructor.id=:data",Course.class);
        query.setParameter("data",theId);
        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByJoinFetch(int theId) {
        TypedQuery<Instructor> query=entityManager.createQuery("SELECT i FROM Instructor i"
        +" JOIN FETCH i.courses"
        +" JOIN FETCH i.instructorDetail"
        +" WHERE i.id=:data", Instructor.class);
        query.setParameter("data",theId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override

    public Course findCourseById(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    public Instructor delete(int theId) {
        Instructor tempInstructor= entityManager.find(Instructor.class,theId);

        return null;
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
//        retrieve the course
        Course tempCourse=entityManager.find(Course.class,theId);
//        delete the course
        entityManager.remove(tempCourse);
    }
}
