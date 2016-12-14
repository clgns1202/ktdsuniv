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
	<h1>관리자 등록</h1>
	<form method="post" action="<c:url value="/admin/adminDoRegister"/>" >
		아이디 : <input type="text" name="userId" id="userId" /><br/>
		비밀번호 : <input type="password" name="userPassword" id="userPassword" /><br/>
		이름 : <input type="text" name="userName" id="userName" style="width: 100px;"/><br/>
		주민번호 : <input type="text" name="birthday" id="birthday" style="width: 80px;"/> - <input type="text" name="gender" id="gender" style="width: 15px;"/>* * * * * * ex) 1988-12-13<br/>
		핸드폰 : <input type="text" name="phoneNumber" id="phoneNumber" /><br/>		
		주소 : <input type="text" name="address" id="address" style="width: 500px;"/><br/><br/>	
		부서 : <input type="text" name="department" id="department" /><br/>
		직급 : <input type="text" name="position" id="position" /><br/><br/>
		<input type="submit"  value="관리자 등록"/>
	</form>
</body>
</html>