package org.lcz.controller;

import org.lcz.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
public class RibbonController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/all")
    public Collection<Student> queryAll() {
        return restTemplate.getForObject("http://provider/all", Collection.class);
    }

    @GetMapping("/index")
    public String getIndex() {
        return restTemplate.getForObject("http://provider/index", String.class);
    }
}
