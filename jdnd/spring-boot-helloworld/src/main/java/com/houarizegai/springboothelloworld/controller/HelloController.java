package com.houarizegai.springboothelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    Map<String, Object> result = new HashMap<>();

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello() {
        result.put("name", "Houari");
        result.put("city", "Tiaret");
        return result;
    }
}
