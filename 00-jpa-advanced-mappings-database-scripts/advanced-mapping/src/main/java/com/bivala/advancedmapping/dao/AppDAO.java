package com.bivala.advancedmapping.dao;

import com.bivala.advancedmapping.entity.Instructor;
import com.bivala.advancedmapping.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorByID(int theId);
    InstructorDetail findInstructorDetailByID(int theId);

    void deleteInstructorByID(int theId);

    void deleteInstructorDetailByID(int theId);

}
