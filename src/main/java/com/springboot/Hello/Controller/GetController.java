package com.springboot.Hello.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// class 수준에서 @requestMapping을 설정하면 내부에 선언한 메소드의 URL 리소스 앞에 @requestMapping의 값이 공통 값으로 추가됨
@RequestMapping("/api/v1/get-api")
public class GetController {

	// http://localhost:8080/api/v1/get-api/hello
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHello() {
		return "GET Hello World";
	}
	// http://localhost:8080/api/v1/get-api/name

	// requestMapping은 더이상 사용하지 않는다.
	@GetMapping("/name")
	public String getName() {
		return "GET Peter";
	}

	// http://localhost:8080/api/v1/get-api/variable1/{String 값}
	@GetMapping("/variable1/{variable}")
	public String getVariable1(@PathVariable String variable) {
		// @PathVariable은 URL에 값을 담아 전달되는 요청을 처리하는 방법을 보여줍니다.
		// @getMapping 어노테이션과 @pathVariable에 지정된 변수의 이름을 동일하게 맞춰야 합니다.
		return variable;
	}

	// http://localhost:8080/api/v1/get-api/variable2/{String 값}
	@GetMapping("/variable2/{variable}")
	public String getVariable2(@PathVariable("variable") String var) {
		// @GetMapping 중괄호 변수명과 @PathVariable 변수명을 일치하기 어렵다면 괄호를 열고 명시해주면됨
		return var;
	}
	
}
