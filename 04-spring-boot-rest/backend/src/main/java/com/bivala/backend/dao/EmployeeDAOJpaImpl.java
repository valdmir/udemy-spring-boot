package com.bivala.backend.dao;

import com.bivala.backend.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query= entityManager.createQuery("FROM Employee ORDER BY id ASC",Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findByID(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteByID(int id) {
        Employee needToDeleteEmployee=findByID(id);
        entityManager.remove(needToDeleteEmployee);
    }
}
