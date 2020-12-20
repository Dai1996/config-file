package org.lcz.controller;

import org.lcz.entity.Student;
import org.lcz.feign.FeignProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
public class FeignController {

    @Resource
    private FeignProviderClient feignProviderClient;

    @GetMapping("/all")
    public Collection<Student> queryAll() {
        return feignProviderClient.queryAll();
    }

    @GetMapping("/index")
    public String getIndex() {
        return feignProviderClient.getIndex();
    }
}
