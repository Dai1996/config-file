package org.lcz.mapper;

import org.lcz.entity.Student;

import java.util.Collection;

public interface StudentMapper {
    Collection<Student> queryAll();
    Student queryStudentById(Integer id);
    void updateStudent(Student student);
    void insertStudent(Student student);
    void deleteStudentById(Integer id);
}
