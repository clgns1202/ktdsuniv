<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#addBtn").click(function(){
			location.href="<c:url value="/room/addRoom"/>";
		});
	});
</script>
	<h3>강의실 목록</h3>
	<c:forEach items="${roomList.pageList}" var="room">
		<div>${room.roomNumber} 
		<a href="<c:url value="/room/delete/${room.id}"/>" style="font-size: 12px">삭제</a></div>	
	</c:forEach>
	<br/>
	<input type="button" value="강의실 추가" id="addBtn" name="addBtn">
<jsp:include page="../common/footer.jsp"></jsp:include>