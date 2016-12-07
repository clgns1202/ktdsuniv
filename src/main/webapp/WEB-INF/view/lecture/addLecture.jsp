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
	
	<form method="post" action="<c:url value="/lecture/doAddLecture"/> ">
	
		강사: <select name="instructor.user.userName" >
			<option>선택하세요.</option>
			<c:forEach items="${instructors.pageList}" var="instructor">
				<option value="${instructor.user.userName}">	
					${instructor.user.userName}
				</option>
			</c:forEach>
		</select>
		<br/>
		
		호실: <select name="room.roomNumber">
			<option>선택하세요.</option>
			<c:forEach items="${rooms.pageList}" var="room">
				<option value="${room.roomNumber}">
					${room.roomNumber}
				</option>
			</c:forEach>
		</select>
		<br />
		
		관리자: <select name="admin.user.userName">	
			<option>선택하세요.</option>
			<c:forEach items="${admins.pageList}" var="admin">
				<option value="${admin.user.userName}">
					${admin.user.userName}
				</option>
			</c:forEach>
		</select>
		<br/>
		
		<p>기간: <input type="date" id="startDate" name="startDate" />
		- <input type="date" id="endDate" name="endDate" /> <br/> </p>
		
		<p>강의시간: <input type="time" id="startTime" name="startTime" />
		- <input type="time" id="endTime" name="endTime" /> <br/> </p>
		
		<p> 강의명: <input type="text" id="lectureName" name="lectureName" placeholder="강의명을 작성해주세요." /></p>
		
		<p>내용:</p> <textarea style="margin: 0px; height: 113px; width: 305px;" id="lectureContent" name="lectureContent" placeholder="강의내용을 작성해주세요."></textarea>
		<input type="submit" id="submitBtn" name="submitBtn" value="등록" /> <br/>
		
	</form>
	
</body>
</html>