<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script src="/webjars/jquery/3.5.1/dist/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		
		});
		
		var page = {
			// 테이블 row 1열 추가 > DB 데이터 추가
			addRow : function() {
				alert("추가");	
			},
			// 테이블 row 1열 삭제 > DB 데이터 삭제
			deleteRow : function() {
				alert("삭제");	
			},
			// 테이블 정보 excel file로 export
			exportFile : function (){
				alert("내보내기");
				// Ajax 비동기 실행
				$.ajax({ 
					url : "/export", 
					type : "post", 
					data : "",
					success : function(data)
					{ 
						if(data)
						{
							alert("파일생성 성공");
						} 
						else
						{
							alert("파일생성 실패");
						}
					}, 
					error : function(a,b,c)
					{ //ajax실패시 원인 
						alert(c); 
					} 
				});
			},
			// 최상단 체크박스 클릭 시 전체 체크 전체 해제
			checkAll : function(){
				var chk = $("#all");
				if(chk.prop('checked'))
				{
					$("input:checkbox[name='dataRow']").each(function(index, item){
						$(this).attr('checked', true);
						$(this).prop('checked', true);
					});
				}
				else
				{
					$("input:checkbox[name='dataRow']").each(function(index, item){
						$(this).attr('checked', false);
						$(this).prop('checked', false);
					});
				}
			},
			// 테이블 row 체크박스 클릭 했을 때
			checkRow : function(){
				
			}
		};
	</script>
	<title>Home</title>
</head>
<body>
	<button id="add" onClick="page.addRow()">add</button>
	<button id="delete" onClick="page.deleteRow()">delete</button>
	<button id="export" onClick="page.exportFile()">export</button>
	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox" id="all" onClick="page.checkAll()"/></th>
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
					<td><input type="checkbox" name="dataRow" id="${user.no}" value="${user.no}"/></td>
					<td><input type="text" id="id" value="${user.id}"/></td>
					<td><input type="text" id="pw" value="${user.pw}"/></td>
					<td><input type="text" id="name" value="${user.name}"/></td>
					<td><input type="text" id="tel_no" value="${user.tel_no}"/></td>
					<td><input type="text" id="delete_yn" value="${user.delete_yn}"/></td>
					<td><input type="text" id="create_date" value="${user.create_date}" disabled="true"/></td>
					<td><input type="text" id="update_date" value="${user.update_date}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
