package com.springboot.Hello.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Hello.Dto.MemberDto;

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
	// http://localhost:8080/api/v1/get-api/request1?name=peter&jop=developer
	@GetMapping("/request1")
	public String getRequestParam1(@RequestParam String name, @RequestParam String jop) {
		return "name is "+ name + " and jop is " +jop;
	}
	// 만약 쿼리스트링에 어떤 값이 들어올지 모른다면 Map 객체를 활용할 수 있음 => 매개변수가 null인 경우 대응하기 좋음(효율적)
	// http://localhost:8080/api/v1/get-api/request2?name=peter&jop=developer
	@GetMapping("/request2")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		// entrySet() 처음 사용해봄,
		/*
		 * entry는 HashMap 요소 key와 value를 쌍으로 갖고 있습니다. 즉 Entry 1개는 요소 1개를 의미합니다.
		 * EntrySet 클래스도 forEach() 메소드를 갖고 있음, 함수형 인터페이스를 인자로 받음
		 */
		param.entrySet().forEach(map ->{
		sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		return sb.toString();
	}
	// 컨트롤러의 메서드에서 쿼리 파라미터의 키와 매핑합니다.
	
	// http://localhost:8080/api/v1/get-api/request3?name=peter&jop=developer&home=yongin
	@GetMapping("/request3")
	public MemberDto getRequestParam3(MemberDto memberDto) {
		return memberDto;
	}
	
	
}
