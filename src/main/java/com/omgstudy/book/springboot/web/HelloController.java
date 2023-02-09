package com.omgstudy.book.springboot.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
// 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다.
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
