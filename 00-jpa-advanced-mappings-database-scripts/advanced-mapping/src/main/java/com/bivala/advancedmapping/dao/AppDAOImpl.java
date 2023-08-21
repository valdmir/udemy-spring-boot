package com.bivala.advancedmapping.dao;

import com.bivala.advancedmapping.entity.Instructor;
import com.bivala.advancedmapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
