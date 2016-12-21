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
		if($("#roomNumber").val() == ""){
			alert("강의실을 입력해주세요");
		}else if($("#seatCount").val() == ""){
			alert("좌석수를 입력해주세요");
		}else{
			$.post("<c:url value='/room/checkDuplicateRoomNumber'/>",{"roomNumber" : $("#roomNumber").val()}, function(data){
							if($("#roomNumber").val() == ${room.roomNumber}){
								$.post("<c:url value='/room/doModifyRoom/${room.id}'/>" , $( "#modifyForm" ).serialize(), function(data){
									 location.href= "<c:url value='/room/roomList'/>"; 
								});
			                }
							else if(data==true){
								alert("강의실 이릉이 중복됩니다.");
							} 
							else {
								$.post("<c:url value='/room/doModifyRoom/${room.id}'/>" , $( "#modifyForm" ).serialize(), function(data){
									 location.href= "<c:url value='/room/roomList'/>"; 
								});
							}
			});
		}	
	});
});
</script>
</head>
<body>
	<h3>강의실 정보 수정</h3>
	<form method="post" id="modifyForm" name="modifyForm" >
		<input type="hidden" value="${room.id}"> 
		호실 : <input type="text" id="roomNumber" name="roomNumber" value="${room.roomNumber}"><br/>
		전체 좌석 수 : <input type="text" id="seatCount" name="seatCount" value="${room.seatCount}"><br/>
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
				<select id="${seat.computer}" name="isComputer">
					<option value="true" id="${seat.computer}" <c:if test="${seat.computer == true}">selected</c:if>>O</option>
					<option value="false" id="${seat.computer}" <c:if test="${seat.computer == false}">selected</c:if>>X</option>
				</select>
			</td>
			
			<td>
				<select id="${seat.mouse}" name="isMouse">
					<option value="true" id="${seat.mouse}" <c:if test="${seat.mouse == true}">selected</c:if>>O</option>
					<option value="false" id="${seat.mouse}" <c:if test="${seat.mouse == false}">selected</c:if>>X</option>
				</select>
			</td>
			
			<td>
				<select id="${seat.monitor}" name="isMonitor">
					<option value="true" id="${seat.monitor}" <c:if test="${seat.monitor == true}">selected</c:if>>O</option>
					<option value="false" id="${seat.monitor}" <c:if test="${seat.monitor == false}">selected</c:if>>X</option>
				</select>
			</td>
			
			<td>
				<select id="${seat.chair}" name="isChair">
					<option value="true" id="${seat.chair}" <c:if test="${seat.chair == true}">selected</c:if>>O</option>
					<option value="false" id="${seat.chair}" <c:if test="${seat.chair == false}">selected</c:if>>X</option>
				</select>
			</td>
	
			<td>
				<select id="${seat.desk}" name="isDesk">
					<option value="true" id="${seat.desk}" <c:if test="${seat.desk == true}">selected</c:if>>O</option>
					<option value="false" id="${seat.desk}" <c:if test="${seat.desk == false}">selected</c:if>>X</option>
				</select>
			</td>

			<td>
				<select id="${seat.keyboard}" name="isKeyboard">
					<option value="true" id="${seat.keyboard}" <c:if test="${seat.keyboard == true}">selected</c:if>>O</option>
					<option value="false" id="${seat.keyboard}" <c:if test="${seat.keyboard == false}">selected</c:if>>X</option>
				</select>
			</td>	
		
		</tr>
		</c:forEach>
	
	</table>
		<input type="button" value="수정" id="modifyBtn" name="modifyBtn">
	</form>
</body>
</html>