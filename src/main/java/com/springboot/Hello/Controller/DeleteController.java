package com.springboot.Hello.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
	// Delete Api는 웹 애플리케이션 서버를 거쳐 데이터베이스 등의 저장소에 있는 리소스를 삭제 할때 사용합니다.
	// 클라이언트으로 부터 값을 받아 데이터베이스나 캐시에 있는 리소스를 조회하고 삭제하는 역할을 수행합니다.
	
	// http://localhost:8080/api/v1/delete-api/{string 값}
	public String deleteVariable(@PathVariable String variable) {
		
		return variable;
	}
}
