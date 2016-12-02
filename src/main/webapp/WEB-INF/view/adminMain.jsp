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
</body>
</html>