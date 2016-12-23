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
		<div>
		<a href="<c:url value="/room/detail/${room.id}"/>">${room.roomNumber}  </a>( 좌석 ${room.seatCount } )
		</div>	
	</c:forEach>
	<br/>
	<form id="searchForm" name="searchForm">
		${paging}
	</form>
	<br/>
	
	<input type="button" value="강의실 추가" id="addBtn" name="addBtn">
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
