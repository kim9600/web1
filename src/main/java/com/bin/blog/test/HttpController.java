package com.bin.blog.test;


import org.springframework.web.bind.annotation.*;

@RestController
public class HttpController {

    private static final String TAG = "HttpControllerTest:";

    @GetMapping("/http/lombok")
    public String lombokTest(){
        //@AllArgsConstructor
        //Member m = new Member(1,"ssar","1234","email");
        //@NoArgsConstructor
        //Member m1 = new Member();
        Member m = Member.builder().username("ssar").password("1234")
                .email("ssar@naver.com").build();
        System.out.println(TAG+"getter:"+ m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG+"setter:"+ m.getUsername());
        return "lombok test 완료";
    }

    @GetMapping("/http/get")
    public String getTest(Member m){

        return "get 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword();
    }
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m){
        return "post 요청 :"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }
    @PutMapping("/http/put")
    public String putTest(){
        return "put 요청";
    }
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}
