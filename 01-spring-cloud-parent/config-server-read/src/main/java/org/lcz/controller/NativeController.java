package org.lcz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NativeController {

    @Value("${server.port}")
    private String port;

    @Value("${foo}")
    private String foo;

    @GetMapping("/msg")
    public String getMsg() {
        return "当前端口为:" + this.port + "\n" + "foo:" + this.foo;
    }
}
