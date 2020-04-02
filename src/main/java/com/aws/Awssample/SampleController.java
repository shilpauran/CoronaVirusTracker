package com.aws.Awssample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping("/test")
    public String test(){
        return "Hello World";
    }
}
