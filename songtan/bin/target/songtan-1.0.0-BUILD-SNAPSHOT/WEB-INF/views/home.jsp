<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script src="/webjars/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready({
			alert('시작');
		});	
	</script>
	<title>Home</title>
</head>
<body>
	<button id="add">add</button>
	<button id="delete">delete</button>
	<button id="export">export</button>
	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox" id="all"/></th>
				<th>ID</th>
				<th>PW</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>삭제여부</th>
				<th>생성일</th>
				<th>수정일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${info}" varStatus="status">			
				<tr>
					<td><input type="checkbox" id=""/></td>
					<td>${user.id}</td>
					<td>${user.pw}</td>
					<td>${user.name}</td>
					<td>${user.tel_no}</td>
					<td>${user.delete_yn}</td>
					<td>${user.create_date}</td>
					<td>${user.update_date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
