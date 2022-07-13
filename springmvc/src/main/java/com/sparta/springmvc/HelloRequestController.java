package com.sparta.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class HelloRequestController {

    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // [Request sample]
// GET http://localhost:8080/hello/request/star/BTS/age/28
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age) // @PathVariable url의 정보를 가져옴
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// GET http://localhost:8080/hello/request/form/param?name=BTS&age=28  form으로 받더라도 get이라면 url param? 뒤에 정보 출력
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age) { // @RequestParam을 통해 정보 가져옴
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/param url에 저장 X
// Header
// Content type: application/x-www-form-urlencoded
// Body
// name=BTS&age=28 Post는 Get과 달리 body에 내용 저장, url에 내용을 숨기기 위해 사용되기도 함
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) { // @RequestParam은 생략 가능
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/model
// Header
// Content type: application/x-www-form-urlencoded
// Body
// name=BTS&age=28
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) { // 객체(여기서는 Star)를 만들어주어 객체로 받게함
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    } // 가져올 변수가 많을 경우 관리 or 미관을 위해 사용 @Setter 필수

    // [Request sample]
// POST http://localhost:8080/hello/request/form/json
// Header
// Content type: application/json
// Body
// {"name":"BTS","age":"28"}
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }
}