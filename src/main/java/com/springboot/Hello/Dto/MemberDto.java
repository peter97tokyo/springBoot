package com.springboot.Hello.Dto;

public class MemberDto {
	/*
	 * DTO는 Data Transfer Object의 약자로, 다른 레이어 간의 데이터 교환에 활용됩니다. 
	 * DTO는 데이터 교환하는 용도로만 사용하는 객체이기 때문에 DTO에는 별도의 로직이 포함되지 않습니다.
	 * 
	 * VO Value Object는 데이터 그자체로 의미가 있는 객체를 의미합니다. VO의 가장 특징적인 부분은 읽기전용으로 설계한다는 점입니다. 
	 * 즉 VO는 값을 변경할 수 없게 만들어 데이터의 신뢰성을 유지해야 합니다.  
	 * */
	private String name;
	private String jop;
	private String home;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJop() {
		return jop;
	}
	public void setJop(String jop) {
		this.jop = jop;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	
	
	@Override
	public String toString() {
		
		return "MemberDto{" 
		+ "name='" + name + '\'' + 
		", jop='" + jop + '\'' + 
		", home='" + home + '\'' + "}";
				
	}
	
	
	
	
	
}
