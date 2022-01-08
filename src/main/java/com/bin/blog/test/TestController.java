package com.bin.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/hello")
    public String hello() {
        return "<h1>hello spring boot 12345</h1>";


    }


    public static void main(String[] args) {

        System.out.println("|\\_/|");
        System.out.println("|q p|    /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
    }
}