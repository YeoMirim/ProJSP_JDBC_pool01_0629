<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ici.dao.*" %>		<!-- jsp파일에서 import -->
<%@ page import="com.ici.dto.*" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList 출력</title>
</head>
<body>
<%
	MemberDao dao = new MemberDao();
	ArrayList<MemberDto> dtos = dao.memberList();	// arrayList로 만들어서 dtos로 호출

	
	for (int i=0; i<dtos.size(); i++) {		// ArrayLst는 length가 없고 size로 사용
		
		MemberDto dto = dtos.get(i);	// 0을 넣으면 첫번째 dtos만(레코드) 가져옴
		String mId = dto.getId();
		String mPW = dto.getPw();
		String mName = dto.getName();
		String mEmail = dto.getEmail();
		String mPhone = dto.getPhone();
		String mGender = dto.getGender();
		
		out.println("아이디 : " + mId);		// web에 찍을땐 System을 뺌
		out.println("<br>");
		out.println("비밀번호 : " + mPW);
		out.println("<br>");
		out.println("이름 : " + mName);
		out.println("<br>");
		out.println("이메일 : " + mEmail);
		out.println("<br>");
		out.println("전화번호 : " + mPhone);
		out.println("<br>");
		out.println("성별 : " + mGender);
		out.println("<br>");
		out.println("================================");
		out.println("<br>");
		
	}
%>
</body>
</html>