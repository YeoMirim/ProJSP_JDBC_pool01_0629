package com.ici.dto;

public class MemberDto {		// DTO는 각 필드값을 한번에 저장할 데이터 구조를 구현 (계층 간 데이터 교환을 하기 위해 사용하는 객체)

	private String id;		// DTO는 필드명과 같은 이름을 줘야 자동으로 값을 넣어줌
	private String pw;
	private String name; 
	private String email;
	private String phone;
	private String gender;
	
	public MemberDto() {		// 생성자는 필요없어도 만드는게 좋음
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String id, String pw, String name, String email, String phone, String gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}	// 객체 초기화 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
}
