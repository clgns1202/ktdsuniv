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
		$.post( "<c:url value ="/room/roomList/"/>", {}, function(data) {
			console.log(data);
			for ( var i in data ) {
				var roomList = $("<div class='roomList' data-id='" + data[i].id + "'></div>");
				roomList.append( $("<p>" + data[i].roomNumber + "</p>") );
				$( "#roomList" ).append( roomList ); 
			}
			
		});
	});
		
	
</script>
</head>
<body>
	<h3>강의실 등록</h3>
	<form method="post" action="<c:url value="/room/doAddRoom"/>" id="addForm" name="addForm" >
		호실 : <input type="text" id="roomNumber" name="roomNumber">
		좌석수 : <input type="text" id="seatNumber" name="seatNumber">
		<input type="submit" value="등록">
	</form>
	
	<div id="roomList">
	
	</div>
</body>
</html>