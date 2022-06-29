package com.ici.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ici.dto.MemberDto;


public class MemberDao {	// DAO는 데이터베이스의 data에 접근하기 위한 객체, Method형태로 사용 
	
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/odbo";
	private String username = "root";
	private String password = "12345";			// 멤버변수로 선언해서 한번에 부르게 만듬
	
	
	public MemberDao() {		// 생성자 만들어서 자동 호출
		try {
			Class.forName(driverName);	//드라이버 로딩
		}
		catch (Exception e) {		// 에러가 난 경우
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDto> memberList() { // Method 선언, 호출시 arrayList를 return 해줘야함
		// 여러 자료를 한번에 담아서 보낼 수 있는 자료구조는 arrayList (Generic)
		
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from testmember");
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");		// 해당값을 하나씩 빼옴
				
//				[방법 1]
//				MemberDto dto = new MemberDto(id, pw, name, email, phone, gender);		// 해당될 때 새로 dto 객체(빈 박스) 생성, 여러명을 가져와야 하므로
				// 생성자로 만들어주면 동일한 내용으로 덮어씌우지 않음(초기화)

//				[방법 2]				
				MemberDto dto = new MemberDto();
				
				dto.setId(id);		// dto에 빼온 값을 넣어줌
				dto.setPw(pw);
				dto.setName(name);
				dto.setEmail(email);
				dto.setPhone(phone);
				dto.setGender(gender);
				// 해당되는 레코드의 값으로 setting, dto 완성(레코드 1개 완성)
				
				dtos.add(dto);
			}
			
			for (int i=0; i<dtos.size(); i++) {		// ArrayLst는 length가 없고 size로 사용
				
				MemberDto dto = dtos.get(i);	// 0을 넣으면 첫번째 dtos만(레코드) 가져옴
				String mId = dto.getId();
				String mPW = dto.getPw();
				String mName = dto.getName();
				String mEmail = dto.getEmail();
				String mPhone = dto.getPhone();
				String mGender = dto.getGender();
				
				System.out.println("아이디 : " + mId);
				System.out.println("비밀번호 : " + mPW);
				System.out.println("이름 : " + mName);
				System.out.println("이메일 : " + mEmail);
				System.out.println("전화번호 : " + mPhone);
				System.out.println("성별 : " + mGender);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;	// 빼내온 다중의 레코드 값들을 반환함
	}
}
