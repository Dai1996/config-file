package org.lcz.feign;

import org.lcz.entity.Student;
import org.lcz.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider", fallback = FeignError.class)
public interface FeignProviderClient {
    @GetMapping("/all")
    Collection<Student> queryAll();
    @GetMapping("/index")
    String getIndex();
}
