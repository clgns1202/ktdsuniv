<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
	<form method="post" action="<c:url value="/lecture/doModifyLectureAction"/> ">
		<input type="hidden" name="id" value="${lecture.id}">
		강사: <select name="instructor.user.userName" >
			<option>선택하세요.</option>
			<c:forEach items="${instructors.pageList}" var="instructor">
				<option value="${instructor.user.userName}" ${instructor.user.userName eq lecture.instructor.user.userName ? "selected" : ""}>	
					${instructor.user.userName}
				</option>
			</c:forEach>
		</select>
		<br/>
		
		호실: <select name="room.roomNumber">
			<option>선택하세요.</option>
			<c:forEach items="${rooms.pageList}" var="room">
				<option value="${room.roomNumber}" ${room.roomNumber eq lecture.room.roomNumber ? "selected" : ""}>
					${room.roomNumber}
				</option>
			</c:forEach>
		</select>
		<br />
		
		관리자: <select name="admin.user.userName">	
			<option>선택하세요.</option>
			<c:forEach items="${admins.pageList}" var="admin">
				<option value="${admin.user.userName}" ${admin.user.userName eq lecture.admin.user.userName ? "selected" : "" }>
					${admin.user.userName}
				</option>
			</c:forEach>
		</select>
		<br/>
		
		<p>기간: <input type="date" id="startDate" name="startDate" value="${lecture.startDate}" />
		- <input type="date" id="endDate" name="endDate" value="${lecture.endDate}" /> <br/> </p>
		
		<p>강의시간: <input type="time" id="startTime" name="startTime" value="${lecture.startTime}" />
		- <input type="time" id="endTime" name="endTime" value="${lecture.endTime}" /> <br/> </p>
		
		<p> 강의명: <input type="text" id="lectureName" name="lectureName" value="${lecture.lectureName}" /></p>
		
		<p>내용:</p> <textarea style="margin: 0px; height: 113px; width: 305px;" id="lectureContent" name="lectureContent" >${lecture.lectureContent}</textarea>
		<input type="submit" id="submitBtn" name="submitBtn" value="수정하기" /> <br/>
		
	</form>
<jsp:include page="../common/footer.jsp"></jsp:include>