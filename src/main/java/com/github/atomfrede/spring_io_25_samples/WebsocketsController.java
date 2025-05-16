package com.github.atomfrede.spring_io_25_samples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("websockets")
public class WebsocketsController {


    @GetMapping
    public String index(){
        return "websockets";
    }

}
