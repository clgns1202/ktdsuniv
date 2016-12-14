<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
>>>>>>> 5a1096fd0a4b3d73d048a9828fcc1f634fe8dd8b
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<<<<<<< HEAD
</head>
<body>

=======
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	
	$().ready(function() {
		
		$("#deleteBtn").click(function () {
			location.href="<c:url value="/lecture/doDeleteLectureAction/${lecture.id}"/>";
		});
		
		$("#modifyBtn").click(function () {
			location.href="<c:url value="/lecture/modify/${lecture.id}"/>";
		});
		
	});
	
</script>
</head>
<body>

	<h1>${lecture.lectureName}</h1>
	<h5>강사: ${lecture.instructor.user.userName}</h5>
	<h5>관리자: ${lecture.admin.user.userName}</h5>
	<h5>호실: ${lecture.room.roomNumber}</h5>
	<h5>기간: ${lecture.startDate} - ${lecture.endDate} </h5>
	<h5>강의시간: ${lecture.startTime} - ${lecture.endTime}</h5>
	<hr/>
	
	<h4>${lecture.lectureContent}</h4>
	
	<input type="button" id="deleteBtn" name="deleteBtn" value="삭제" />
	<input type="button" id="modifyBtn" name="modifyBtn" value="수정" />

>>>>>>> 5a1096fd0a4b3d73d048a9828fcc1f634fe8dd8b
</body>
</html>