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
		$("#modifyBtn").click(function(){
			location.href="<c:url value="/room/modifyRoom/${room.id}"/>";
		});
		$("#deleteBtn").click(function(){
			if(confirm("정말 삭제하시겠습니까?")==true){
				location.href="<c:url value="/room/deleteRoom/${room.id}"/>";
			}else{
				return;
			}
		});
		$("#backBtn").click(function(){
			location.href="<c:url value="/room/roomList"/>";
		});
	});
</script>
</head>
<body>
	강의실 : ${room.roomNumber}
	좌석 수 : ${room.seatCount }

	<table border="1" >
		<tr>
			<td>좌석번호</td>
			<td>컴퓨터</td>
			<td>마우스</td>
			<td>모니터</td>
			<td>의자</td>
			<td>책상</td>
			<td>키보드</td>
		</tr>
		
		
		<c:forEach items="${room.seat}" var="seat">
		<tr>	
		<td>${seat.seatNumber+1}</td>
		
			<td>
				<c:if test="${seat.computer == 'true'}">O</c:if>
				<c:if test="${seat.computer == 'false'}">X</c:if>
			</td>
			
			<td>
				<c:if test="${seat.mouse == 'true'}">O</c:if>
				<c:if test="${seat.mouse == 'false'}">X</c:if>
			</td>
			
			<td>
				<c:if test="${seat.monitor == 'true'}">O</c:if>
				<c:if test="${seat.monitor == 'false'}">X</c:if>
			</td>
			
			<td>
				<c:if test="${seat.chair == 'true'}">O</c:if>
				<c:if test="${seat.chair == 'false'}">X</c:if>
			</td>
	
			<td>
				<c:if test="${seat.desk == 'true'}">O</c:if>
				<c:if test="${seat.desk == 'false'}">X</c:if>
			</td>

			<td>
				<c:if test="${seat.keyboard == 'true'}">O</c:if>
				<c:if test="${seat.keyboard == 'false'}">X</c:if>
			</td>	
		
		</tr>
		</c:forEach>
	
	</table>
	<input type="button" value="수정" id="modifyBtn" name="modifyBtn" > 
	<input type="button" value="삭제" id="deleteBtn" name="deleteBtn" > <br/>
	<input type="button" value="뒤로가기" id="backBtn" name="backBtn" > 
</body>
</html>