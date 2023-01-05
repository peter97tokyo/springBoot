package com.springboot.Hello.Controller;

import java.util.Map;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Hello.Dto.MemberDto;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	/*
	 * POST API는 웹 애플리케이션을 통해 데이터베이스등의 저장소에 리소스를 저장할 때 사용되는 API입니다.
	 * POST API에서는 저장하고자 하는 리소스나 값을 HTTP 바디(body)에 담아 서버에 전달합니다.
	 *  */
	@RequestMapping(value= "/domain", method = RequestMethod.POST)
	public String postExample() {
		return "POST Post API";
	}
	
	// 일반적으로 POST 형식의 요청은 클라이언트가 서버에 리소스를 저장하는 데 사용합니다.
	// http://localhost:8080/api/v1/post-api/member
	@PostMapping("/member")
	public String postMember(@RequestBody Map<String, String> postData) {
		StringBuilder sb = new StringBuilder();
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey()+" : "+map.getValue() + "\n");
		});
		return sb.toString(); 
	}
	
	
	// 요청 메시지에 들어갈 값이 정해져 있다면 아래와 같이 DTO 객체를 매개변수로 삼아 작성할수 있음
	// http://localhost:8080/api/v1/post-api/member2
	@PostMapping("/member2")
	public String postMemberDto(@RequestBody MemberDto memberDto) {
		return memberDto.toString();
	}
	
	
	
	
}
