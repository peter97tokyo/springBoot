package com.springboot.Hello.Controller;

import java.lang.reflect.Member;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Hello.Dto.MemberDto;

@RestController // ==> @ResponseBody를 생략할 수 있음
@RequestMapping("/api/v1/put-api")
public class PutController {
	/*
	 * PUT API는 웹 애플리케이션 서버를 통해 데이터베이스같은 저장소에 존재하는 리소스 값을 업데이트하는데 사용합니다.
	 */
	
	// http://localhost:8080/api/v1/put-api/member
	// 서버에 어떤 값이 들어올지 모른다면 Map 객체를 활용해 값을 받을 수 있습니다.
	@PutMapping("/member")
	public String postMember(@RequestBody Map<String, String> putData) {
		StringBuilder sb = new StringBuilder();
		putData.entrySet().forEach(map ->{ 
			sb.append(map.getKey() + " : "+ map.getValue() + "\n");
		});
		return sb.toString();
	}
	// http://localhost:8080/api/v1/put-api/member1 
	@PutMapping("/member1")
	public String postMemberDto1(@RequestBody MemberDto memberDto) {
		return memberDto.toString(); // Content-Type:	text/plain;charset=UTF-8 ===> 결과값 일반 문자열 
	}
	// http://localhost:8080/api/v1/put-api/member2
	@PutMapping("/member2")
	public MemberDto postMemberDto2(@RequestBody MemberDto memberDto ) {
		return memberDto; // Content-Type:	 application/json ===> 결과값 json
	}
	/*
	 * spring framework has HttpEntity
	 * RequestEntity and ResponseEntity extends HttpEntity
	 * RequestEntity, ResponseEntity
	 * 이 클래스를 활용하면 응답 코드 변경은 물론 Header와 body를 더욱 쉽게 구성할 수 있습니다.
	 * 
	 *  */
	@PutMapping("/member3")
	public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto); // HttpStatus.ACCEPTED ==> 응답코드가 202으로 변함 
	}
}
