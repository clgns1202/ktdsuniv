<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${instructors.pageList}" var="instructor">
		강사아이디${instructor.user.userName}//<br/>
	</c:forEach>
	<c:forEach items="${rooms.pageList}" var="room">
		룸아이디${room.roomNumber}//<br/>
	</c:forEach>
	<c:forEach items="${admins.pageList}" var="admin">
		담당자 아이디${admin.user.userName}//<br/>
	</c:forEach>
	

</body>
</html>