package org.lcz.controller;

import org.lcz.entity.Student;
import org.lcz.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
public class StudentController {
    @Resource
    private StudentMapper studentMapper;

    @Value("${server.port}")    //读取application.yml配置文件中端口
    private String port;

    @GetMapping("/all")
    public Collection<Student> queryAll() {
        return studentMapper.queryAll();
    }

    @GetMapping("/find/{id}")
    public Student queryStudentById(@PathVariable("id") Integer id) {
        return studentMapper.queryStudentById(id);
    }

    @PostMapping("/insert")
    public void insertStudent(@RequestBody Student student) {
        //@RequestBody:将json数据格式映射为student对象
        studentMapper.insertStudent(student);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentMapper.updateStudent(student);
    }

    @DeleteMapping("/del/{id}")
    public void deleteStudentById(@PathVariable("id") Integer id) {
        studentMapper.deleteStudentById(id);
    }

    @GetMapping("/index")
    public String getIndex() {
        return "服务提供者端口:" + this.port;
    }
}
