package com.springboot.Hello.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	// sts4에서 자바 17만 지원함 처음에 openJDK 11를 사용하다가 2시간 허비됨 
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
}
