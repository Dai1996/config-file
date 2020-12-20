package org.lcz.feign.impl;

import org.lcz.entity.Student;
import org.lcz.feign.FeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Collection<Student> queryAll() {
        return null;
    }

    @Override
    public String getIndex() {
        return "服务器正在维护中...";
    }
}
