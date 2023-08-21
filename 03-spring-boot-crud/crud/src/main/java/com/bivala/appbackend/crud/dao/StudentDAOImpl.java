package com.bivala.appbackend.crud.dao;

import com.bivala.appbackend.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
//    Define field for entity manager
private EntityManager entityManager;
//    inject entity manager using constructor injection
//    implement save method
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.
                createQuery("From Student order by firstName DESC",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery=entityManager.
                createQuery("FROM Student WHERE lastName LIKE :data ",Student.class);
        theQuery.setParameter("data",lastName+"%");
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public Student update(Student theStudent) {

        return entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public int updateWithQuery(String firstName,String lastName, Integer id) {

        Query query =entityManager.
                createQuery("UPDATE Student SET lastName=:lastName, " +
                        "firstName=:firstName WHERE id=:id")
                .setParameter("firstName",firstName)
                .setParameter("lastName",lastName)
                .setParameter("id",id);
        int rows=query.executeUpdate();
        return rows;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        Query query =entityManager.
                createQuery("Delete FROM Student");
        return query.executeUpdate();
    }
}
