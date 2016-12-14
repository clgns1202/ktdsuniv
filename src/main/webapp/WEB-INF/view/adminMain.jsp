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
	담당자 메인 페이지<br/><br/>
	<input type="button" value="로그아웃" onclick="location.href='<c:url value="/admin/adminSignOut" />'"/>
	
	<table>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>성적</td>
			<td>전화번호</td>
			<td>생성일</td>
			<td>수정일</td>
		</tr>
			<c:forEach items="${userList.pageList}" var="user" end="4">
				<tr>	
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.birthday}</td>
					<td>${user.gender}</td>
					<td>${user.address}</td>
					<td>${user.phoneNumber}</td>
					<td>${user.createdDate}</td>
					<td>${user.modifiedDate}</td>
				</tr>
			</c:forEach>
	</table>
	
	
</body>
</html>