<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#addBtn").click(function(){
			location.href="<c:url value="/room/addRoom"/>";
		});
	});
</script>
</head>
<body>
	<h3>강의실 목록</h3>
	<c:forEach items="${roomList.pageList}" var="room">
		<div>
		<a href="<c:url value="/room/detail/${room.id}"/>">${room.roomNumber} </a>
		</div>	
	</c:forEach>
	
	<br/>
	
	<form id="searchForm" name="searchForm">
		${paging}
	
	</form>
	<br/>
	<input type="button" value="강의실 추가" id="addBtn" name="addBtn">
	
</body>
</html>