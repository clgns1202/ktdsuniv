<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
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
	<h3>강의실 등록</h3>
	<form method="post" action="<c:url value="/room/doAddRoom"/>" id="addForm" name="addForm" >
		호실 : <input type="text" id="roomNumber" name="roomNumber">
		좌석수 : <input type="text" id="seatNumber" name="seatNumber">
		<input type="submit" value="등록">
	</form>
	
	<div id="roomList">
	
	</div>
<jsp:include page="../common/footer.jsp"></jsp:include>