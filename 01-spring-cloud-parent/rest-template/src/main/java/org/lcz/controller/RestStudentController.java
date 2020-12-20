package org.lcz.controller;

import org.lcz.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
public class RestStudentController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        return restTemplate.getForEntity("http://localhost:8888/all", Collection.class).getBody();
    }

    @GetMapping("/all")
    public Collection<Student> queryAll() {
        return restTemplate.getForObject("http://localhost:8888/all", Collection.class);
    }

    @GetMapping("/query/{id}")
    public Student queryStudentById(@PathVariable("id") Integer id) {
        return restTemplate.getForEntity("http://localhost:8888/find/{id}", Student.class, id).getBody();
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://localhost:8888/find/{id}", Student.class, id);
    }

    @PostMapping("/insert")
    public void insertStudent(@RequestBody Student student) {
        restTemplate.postForEntity("http://localhost:8888/insert", student, null).getBody();
    }

    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student) {
        restTemplate.postForObject("http://localhost:8888/insert", student, null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        restTemplate.put("http://localhost:8888/update", student);
    }

    @DeleteMapping("del/{id}")
    public void delete(@PathVariable("id") Integer id) {
        restTemplate.delete("http://localhost:8888/del/{id}", id);
    }
}
