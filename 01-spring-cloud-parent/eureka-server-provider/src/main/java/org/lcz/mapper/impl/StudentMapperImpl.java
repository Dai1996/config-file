package org.lcz.mapper.impl;

import org.lcz.entity.Student;
import org.lcz.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentMapperImpl implements StudentMapper {

    private static Map<Integer, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1, new Student(1, "张三", 20));
        studentMap.put(2, new Student(2, "李四", 21));
        studentMap.put(3, new Student(3, "王五", 22));
        studentMap.put(4, new Student(4, "朱六", 23));
    }

    @Override
    public Collection<Student> queryAll() {
        return studentMap.values();
    }

    @Override
    public Student queryStudentById(Integer id) {
        return studentMap.get(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void insertStudent(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentMap.remove(id);
    }
}
