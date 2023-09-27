<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String ipage = (String)request.getAttribute("page");	
%>
<table style="width:100%">
	<thead>
		<tr>
			<td>
				<%-- <% pageContext.include("header.jsp");%> --%>
				<jsp:include page="header.jsp"/>
			</td>
		</tr>
	</thead>
	<%if(ipage!=null) { %>
	<tbody>
		<tr>
			<td>					
			<jsp:include page = '<%=ipage+".jsp" %>'/>
			<%} %>
			</td>
		</tr>
	</tbody>

</table>
</body>
</html>