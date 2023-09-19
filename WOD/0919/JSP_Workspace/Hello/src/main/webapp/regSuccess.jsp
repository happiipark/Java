<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=request.getParameter("name")%>님 회원 가입에 성공하였습니다.</h1>
	<table border = 1>
		<tr>
		<th>주소 </th>
		<td><%=request.getParameter("address") %></td>
		</tr>
		<th>전화번호 </th>
		<td><%=request.getParameter("tell") %></td>
		</tr>
		<th>취미 </th>
		<td><%=request.getParameter("hoby") %></td>
		</tr>

	</table>
</body>
</html>