package org.software.services;

import org.software.entity.Student;

import java.util.List;

public interface StudentService {

        void insert();
        void select();
        void update();
        void delete();
        void checkByBoysAndGirlsQuantity();
        void checkTotalStudentByClassRoomNo();
        void checkMaxStudentInClass();

}
