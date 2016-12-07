<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	
	$().ready(function () {
		
		$("#insertBtn").click(function () {
			location.href="<c:url value="/lecture/addLecture"/>";
		});
	});

</script>
</head>
<body>

	<table>
		<tr>
			<td>강사</td>
			<td>강의명</td>
			<td>기간</td>
		</tr>
	</table>
	
	<c:forEach items="${lectureList.pageList}" var="lectureList">
		<table>
			<tr>
				<td>${lectureList.instructor.user.userName}</td>
				<td> <a href="<c:url value="/lecture/detail/${lectureList.id}"/> ">${lectureList.lectureName}</a></td>
				<td>${lectureList.startDate} - ${lectureList.endDate}</td>
			</tr>
		</table>
	</c:forEach>
	
	<input type="button" id="insertBtn" name="insertBtn" value="등록하기" />
</body>
</html>