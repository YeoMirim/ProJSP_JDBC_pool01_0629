<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%! 						// 변수 선언
 	Connection conn;
 	PreparedStatement pstmt;
 	ResultSet rs;
 	
 	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/odbo";
	String username = "root";
	String password = "12345";
 %>		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Join </title>
</head>
<body>
<%
	try {
		 Class.forName(driverName);
		 conn = DriverManager.getConnection(url, username, password);
		 String sql = "INSERT INTO testmember(id, pw, name, email, phone, gender) VALUES(?, ?, ?, ?, ?, ?)";	
		 // PreparedStatement는 넣고싶은 데이터의 필드 갯수만큼 ?(parameter, 1부터 시작)를 넣음
		 pstmt = conn.prepareStatement(sql); // sql 인수 삽입 주의
	
		 pstmt.setString(1, "banana");
		 pstmt.setString(2, "12345");
		 pstmt.setString(3, "원숭이");
		 pstmt.setString(4, "monky@abc.com");
		 pstmt.setString(5, "010-6543-8765");
		 pstmt.setString(6, "man");
		 
		 int flag = pstmt.executeUpdate();	// 성공시 1 반환
		 System.out.print(flag);
	}
	catch(Exception e) {
		e.printStackTrace();	
	}
	finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
%>
</body>
</html>